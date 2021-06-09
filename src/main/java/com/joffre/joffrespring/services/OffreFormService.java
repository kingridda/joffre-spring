package com.joffre.joffrespring.services;

import com.joffre.joffrespring.dao.ImageRepository;
import com.joffre.joffrespring.dao.OffreRepository;
import com.joffre.joffrespring.entities.Image;
import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.storage.StorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class OffreFormService {

    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_TITLE       = "title";
    private static final String FIELD_CITY        = "city";
    private static final String FIELD_CATEGORY    = "category";
    private static final String FIELD_FILE        = "file";
    private static final String FIELD_USER        = "user";

    public static final int RANDOM_FILENAME_LEN   = 13;
    private boolean             result            = false;
    private Map<String, String> errors            = new HashMap<String, String>();


    @Autowired
    private OffreRepository offreRepository;
    @Autowired
    private ImageRepository imageRepository;

    private final StorageService storageService;

    @Autowired
    public OffreFormService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
    public boolean getResult(){
        return result;
    }

    public boolean handleForm(Offre offer, MultipartFile file){

        try {
            validateTitle( offer.getTitre() );
        } catch ( Exception e ) {
            setError( FIELD_TITLE, e.getMessage() );
        }
        try {
            validateDescription( offer.getDescription() );
        } catch ( Exception e ) {
            setError( FIELD_DESCRIPTION, e.getMessage() );
        }


//            try{
//                if(user == null){
//                    throw new Exception( "authentication error" );
//            } catch ( Exception e ) {
//                setError( FIELD_USER, e.getMessage() );
//            }

        Image image = new Image();
        List<Image> images = new ArrayList<>();
        image.setPathToImage( random_java8_string(RANDOM_FILENAME_LEN) + file.getOriginalFilename() );
        images.add(image);
        try {
            if( errors.isEmpty() )
                storageService.store(file,  image.getPathToImage());
        } catch ( StorageException e ) {
            setError( FIELD_FILE, e.getMessage() );
        }
        try{
            if(errors.isEmpty()){
                offer.setImages(images);
                imageRepository.save(image);
                offreRepository.save(offer);
            }
        }catch (Exception e){
            setError(FIELD_FILE, e.getMessage());
        }

        //result of the operation
        result = errors.isEmpty();

        return result;
    }

    //validate field description
    private void validateDescription( String description ) throws Exception {
        if ( description != null ) {
            if ( description.length() < 20 ) {
                throw new Exception( "description is too short please use a description with more than 20 characters" );
            }
        } else {
            throw new Exception( "Please enter a description" );
        }
    }
    //validate field title
    private void validateTitle( String title ) throws Exception {
        if ( title != null ) {
            if ( title.length() < 5 ) {
                throw new Exception( "title is too short please use a longer title" );
            }
        } else {
            throw new Exception( "Please enter a title" );
        }
    }




    //adding errors
    private void setError( String field, String message ) {
        errors.put( field, message );
    }
    public  void setErrorsEmpty(){errors.clear();}

    public Map<String, String> getErrors() {
        return errors;
    }

    //random string generator
    private String random_java8_string(int len) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = len;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}

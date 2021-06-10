window.fbAsyncInit = function() {
    FB.init({
        appId      : '{3286155231619263}',
        cookie     : true,
        xfbml      : true,
        version    : '{v11}'
    });

    FB.AppEvents.logPageView();

};
 function checkLoginState() {               // Called when a person is finished with the Login Button.
     FB.getLoginStatus(function(response) {   // See the onlogin handler
         statusChangeCallback(response);
     });
 }

    (function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

 function usingAPI() {  // now connection is set we use the api to fetch data
     FB.api('/me', function(response) {
         console.log(response.name)
         document.getElementById('name').innerHTML =  "Bonjour " +response.name;
         document.getElementById('username').value = response.name;
         document.getElementById('idUser').value = response.id;
     });
 }

 function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
     if (response.status === 'connected') {   // Logged into your webpage and Facebook.
         usingAPI();
     } else {                                 // Not logged into your webpage or we are unable to tell.
         document.getElementById('username').innerHTML = 'Please log ' + 'In.';
     }
 }





 //
 // {
 //     status: 'connected',
 //         authResponse: {
 //     accessToken: '...',
 //         expiresIn:'...',
 //         signedRequest:'...',
 //         userID:'...'
 // }
 // }
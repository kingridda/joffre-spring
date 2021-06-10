function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
        usingAPI();
    } else {                                 // Not logged into your webpage or we are unable to tell.
        document.getElementById('username').innerHTML = 'Please log ' + 'In.';
    }
}

function checkLoginState() {               // Called when a person is finished with the Login Button.
    FB.getLoginStatus(function(response) {   // See the onlogin handler
        statusChangeCallback(response);
    });
}


window.fbAsyncInit = function() {
    FB.init({
        appId      : '{3286155231619263}',
        cookie     : true,                     // Enable cookies to allow the server to access the session.
        xfbml      : true,                     // Parse social plugins on this webpage.
        version    : '{v9.0}'           // Use this Graph API version for this call.
    });

    FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
        statusChangeCallback(response);        // Returns the login status.
    });
};

function usingAPI() {  // now connection is set we use the api to fetch data
    FB.api('/me', function(response) {
        document.getElementById('name').innerHTML =  "Bonjour " +response.name;
        document.getElementById('username').value = response.name;
        document.getElementById('idUser').value = response.id;
    });
}

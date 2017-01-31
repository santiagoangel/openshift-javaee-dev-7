<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (request.getUserPrincipal() != null) {
        String index = request.getContextPath() + "/welcome.html";
        response.sendRedirect(index);
    } else {
%>

<!DOCTYPE html>
<!--[if IE 9]><html class="ie9 login-pf"><![endif]-->
<!--[if gt IE 9]><!-->
<html class="login-pf">
<!--<![endif]-->
  <head>
    <title>Login - Openshift-javaee-dev</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="dist/img/favicon.ico" />
    <!-- iPad retina icon -->
    <link rel="apple-touch-icon-precomposed" sizes="152x152" href="dist/img/apple-touch-icon-precomposed-152.png" />
    <!-- iPad retina icon (iOS < 7) -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="dist/img/apple-touch-icon-precomposed-144.png" />
    <!-- iPad non-retina icon -->
    <link rel="apple-touch-icon-precomposed" sizes="76x76" href="dist/img/apple-touch-icon-precomposed-76.png" />
    <!-- iPad non-retina icon (iOS < 7) -->
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="dist/img/apple-touch-icon-precomposed-72.png" />
    <!-- iPhone 6 Plus icon -->
    <link rel="apple-touch-icon-precomposed" sizes="120x120" href="dist/img/apple-touch-icon-precomposed-180.png" />
    <!-- iPhone retina icon (iOS < 7) -->
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="dist/img/apple-touch-icon-precomposed-114.png" />
    <!-- iPhone non-retina icon (iOS < 7) -->
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="dist/img/apple-touch-icon-precomposed-57.png" />
    <link rel="stylesheet" href="dist/css/patternfly.min.css" />
    <link rel="stylesheet" href="dist/css/patternfly-additions.min.css" />
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="dist/js/patternfly.min.js"></script>
    <script src="dist/js/sec.js"></script>
  </head>

  <body>
    <span id="badge">
      <img src="dist/img/logo.svg" alt="PatternFly logo" />
    </span>
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <div id="brand">
            <h1><strong>Openshift-javaee-dev-7</strong></h1>
          </div><!--/#brand-->
        </div><!--/.col-*-->
        
        <p id="message" style="color:red"></p>
        <div class="col-sm-7 col-md-6 col-lg-5 login">
          <form id="usernamePasswordForm" onsubmit="return false;" class="form-horizontal">
            <div class="form-group">
              <label for="inputUsername" class="col-sm-2 col-md-2 control-label">Username</label>
              <div class="col-sm-10 col-md-10">
                <input class="form-control" id="userName" type="text"
                       name="userName" required placeholder="Your UserName" tabindex="1" />
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword" class="col-sm-2 col-md-2 control-label">Password</label>
              <div class="col-sm-10 col-md-10">
                <input class="form-control" id="password" type="password" name="password" required placeholder="Your Password" tabindex="2" />
              </div>
            </div>
            <div class="form-group">
              <div class="col-xs-8 col-sm-offset-2 col-sm-6 col-md-offset-2 col-md-6">
                
                
              </div>
              <div class="col-xs-4 col-sm-4 col-md-4 submit">
                <input type="submit" name="usernamePasswordBtn" id="usernamePasswordBtn" value="Login" class="btn btn-primary btn-lg"/>
              </div>
            </div>
          </form>
        </div><!--/.col-*-->
        <div class="col-sm-5 col-md-6 col-lg-7 details">
          <p><strong>Welcome to Openshift-javaee-dev-7!</strong><br />
          HTML5/ Java EE 7 application with JPA, JAX-RS, Bean validation, security &amp; PatternFly.</p>
        </div><!--/.col-*-->
      </div><!--/.row-->
    </div><!--/.container-->
   </body>
</html>
<%
    }
%>


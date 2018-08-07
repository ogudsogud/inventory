<%--
  Created by IntelliJ IDEA.
  User: Ogudsogud
  Date: 7/21/2018
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dashboard - Login Page</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

  <link rel="stylesheet" href="css/demo.css">
  <link rel="stylesheet" href="css/font-awesome.css">
  <link rel="stylesheet" href="css/sky-forms.css">
  <link rel="stylesheet" href="css/login.css">
  <link rel="shortcut icon" href="ims.ico" type="image/x-icon" />

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <!--  <link href="css/admin-style.css" type="text/css" rel="stylesheet" /> -->

  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="js1/jquery.min.js"></script>
  <script src="js1/jquery.form.min.js"></script>
  <script src="js1/jquery.modal.js"></script>
  <script src="js1/jquery.validate.min.js"></script>

  <!--[if lt IE 9]>
  <link rel="stylesheet" href="css/sky-forms-ie8.css">
  <![endif]-->


  <script>
    $(function() {

      if (localStorage.chkbx && localStorage.chkbx != '') {
        $('#remember_me').attr('checked', 'checked');
        $('#user').val(localStorage.usrname);
        $('#passw').val(localStorage.pass);
      } else {
        $('#remember_me').removeAttr('checked');
        $('#user').val('');
        $('#passw').val('');
      }

      $('#remember_me').click(function() {

        if ($('#remember_me').is(':checked')) {
          // save username and password
          localStorage.usrname = $('#user').val();
          localStorage.pass = $('#passw').val();
          localStorage.chkbx = $('#remember_me').val();
        } else {
          localStorage.usrname = '';
          localStorage.pass = '';
          localStorage.chkbx = '';
        }
      });
    });

  </script>

  <script type="text/javascript">

    function handleKeyPress(e){
      var key=e.keyCode || e.which;
      if (key==13){
        loginValidation();
      }
    }

    function loginValidation(){
      var user = $("#user").val();
      var passw = $("#passw").val();

      if(user==""){
        $("#user").focus();
        $("#add_msg_user").fadeIn(1000);
        return false;
      }
      else{
        $("#add_msg_user").fadeOut();
      }

      if(passw==""){
        $("#passw").focus();
        if ($("#add_err").is(":visible")) {
          $("#add_err").fadeOut("fast");
        }
        $("#add_err").fadeTo(200,0.1,function()
        {
          $(this).html('Please Enter Password.').removeClass().addClass('myerror').fadeTo(900,1);
        });
        return false;
      }
      else{
        $("#add_msg_pwd").fadeOut("fast");
      }

      $("#add_err").removeClass().addClass('myinfo').text('Validating Your Login').fadeIn(1000);
      $.ajax({
        type: "post",
        url: "loginAuthentication.jsp",
        data: {
          user: user,
          passw: passw
        },
        success: function(data)
        {
          //	alert(data.length);
          if(data.length != 14)
//						if(data=="ERROR")
          {
            if ($("#add_msg_pwd").is(":visible")) {
              $("#add_msg_pwd").fadeOut("fast");
            }

            $("#add_err").fadeTo(200,0.1,function()
            {
              $(this).html('Sorry, Invalid Employee Id And Password.').removeClass().addClass('myerror').fadeTo(900,1);
            });
          }
          else{
            $("#add_err").html('Login Verified, Logging in.....').addClass('myinfo').fadeTo(900,1,
                    function()
                    {
                      document.location='directusers.jsp';
                    });
          }
        }
      });
      return false;
    }

    window.onload = function() {
      document.getElementById("user").focus();
    };
  </script>

</head>

<body>
<div class="header">

  <div class="inner-header">

    <div class="logo-panel">
      <!-- <div class="top-left-nav"><a href="settings.jsp" class="first">Settings</a> <a href="javascript:void(0);" onclick="window.location='logout.jsp';">Sign Out</a> </div>-->
      <div class="logo"><img src="ctllogo.png" border="0" alt="" /></div>
    </div>
    <div class="top-main-navigation">
      <div class="mainNavigation">
        <ul>

        </ul>
      </div>
    </div>

  </div>
  <div class="blue-header">
    <div class="inner-blue-header">
      <div class="welcome page-heading"></div>
    </div>
  </div>

</div>

<div class="clear"></div>

<!-- /Header Div -->
<div class="body body-s">
  <form method="post" action="" name="frmlogin" class="sky-form" id="sky-form">

    <fieldset>
      <section>
        <div class="row">
          <label class="label col col-4" >NIK</label>
          <div class="col col-8">
            <label class="input">
              <i class="icon-append fa fa-user"></i>
              <input type="text" name="nik" id="nik" value="">
              <div class="msg" id="add_msg_nik" style="display:none;color:red;">Silahkan Masukan NIK</div>
            </label>
          </div>
        </div>
      </section>

      <section>
        <div class="row">
          <label class="label col col-4" >Password</label>
          <div class="col col-8">
            <label class="input">
              <i class="icon-append fa fa-lock"></i>
              <input type="password" name="passw" id="passw" value="" onkeypress="handleKeyPress(event)">
              <div class="err" id="add_err" style="color:red;"></div>
              <div class="err" id="add_msg_pwd" style="display:none;color:red;">Silahkan masukkan password</div>
            </label>
            <div class="note"><a href="#sky-form2" class="modal-opener"></a></div>
          </div>
        </div>

      </section>

      <section>
        <div class="row">
          <div class="col col-4"></div>
          <div class="col col-8">
            <label class="checkbox"><input type="checkbox" name="remember" checked id="remember_me"><i></i>Tetap login</label>
          </div>
        </div>
      </section>
    </fieldset>
    <footer>
      <!-- <a href="#" class="button button-secondary" >Cancel</a> -->
      <button type="reset" class="button" value="Reset" >Cancel</button>
      <button type="button" class="button" onclick="loginValidation();">Log in</button>
    </footer>
  </form>
</div>

<!-- Footer Div -->

<%--<div class="footer" align="center" ><img src="images/aproductofCTL.gif" /></div>--%>

<!-- /Footer Div -->

</body>
</html>

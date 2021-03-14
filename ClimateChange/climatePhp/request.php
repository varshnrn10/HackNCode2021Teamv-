<?php
include "climate_conn.php";
$conn = conn();
if (isset($_POST["case"])) {
    switch ($_POST["case"]) {
        case "login":{
           login();
            break;
        }
        case "register":{
            register();
            break;
        }
    }
}

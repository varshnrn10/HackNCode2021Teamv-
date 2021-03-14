<?php
function conn()
{
    $conn = new mysqli("localhost", "root", "", "climate")or die("Unable to connect");
    return $conn;
}
function saveme($con, $string)
{
    return htmlentities(saveme2($con, $string));
}
function saveme2($con, $string)
{
    if (get_magic_quotes_gpc()) {
        $string = stripcslashes($string);
    }

    return $con->real_escape_string($string);
}
function checkAccountExist($mobile)
{
    $con = conn();
    $res = $con->query("select * from credentials where mobile = '$mobile' ");
    if ($res) {
        if ($res->num_rows == 0) {
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}
function NewLogin($mobile, $password)
{
    $con = conn();
    $res = $con->query("select uid,name from credentials where mobile = '$mobile' and password = '$password'");
    $result = array();
    if ($res->num_rows!= 0) {
        $row = $res->fetch_assoc();
        array_push($result, true);
        array_push($result, $row["uid"]);
        array_push($result, $row["name"]);
        return $result;
    } else {
        array_push($result, false);
        return $result;
    }
}
function checkUidexist($uid)
{
    $con = conn();
    $res = $con->query("select * from credentials where id = '$uid' ");

    if ($res) {
        if ($res->num_rows == 0) {
            return false;
        } else {
            return true;
        }
    } else {
        return true;
    }
}
function random_number()
{
    return(rand(1, 10000));
}
function login()
{
    $con = conn();
    if (isset($_POST["mobile"]) && $_POST["password"]) {
        $password = saveme($con, $_POST["password"]);
        $mobile = saveme($con, $_POST["mobile"]);
        $accexist = checkAccountExist($mobile);
        if ($accexist) {
            $creAct =NewLogin($mobile, $password);
            $arr = array("status" => 200, "Message" => "Login Success", "uid" => $creAct[1],"name"=> $creAct[2]);
            if ($creAct[0]) {
                $myJSON = json_encode($arr);
                echo $myJSON;
            } else {
                $arr = array("status" => 202, "Message" => "Password Wrong");
                $myJSON = json_encode($arr);
                echo $myJSON;
            }
        } else {
            $arr = array("status" => 202, "Message" => "Try Again");
            $myJSON = json_encode($arr);
            echo $myJSON;
        }
    }
}
function register()
{
    $conn = conn();
    if (
    isset($_POST['mobile'])
    && isset($_POST['password'])
    && isset($_POST['name'])
    && isset($_POST['email'])
) {
        $uid             = random_number();
        $mobile          = $_POST['mobile'];
        $password        = $_POST['password'];
        $name            = $_POST['name'];
        $email           = $_POST['email'];

        $result = false;
        $resultCheck = $conn->query("SELECT * FROM credentials WHERE mobile='$mobile' LIMIT 1");
        $num_rows    = mysqli_num_rows($resultCheck);

        if ($num_rows > 0) {
            $response["success"] = 1;
            $response["message"] = "Account already exist";
        } else {
            $result = $conn->query("INSERT INTO credentials(`uid`,`mobile`,`email`,`password`,`name`) VALUES('$uid','$mobile','$email','$password','$name')");
            if ($result) {
                $response["success"] = 1;
                $response["message"] = "Registration Successful";
                $response["uid"] =$uid;
                $response["name"] =$name;
            }
        }

        echo json_encode($response);
    }
}

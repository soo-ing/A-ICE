<?php
header("Content-Type: text/html;charset=UTF-8");
$host = 'localhost'; 
$user = 'hostsoo'; 
$pw = 'ice135##'; 
$dbName = 'hostsoo'; 
$mysqli = new mysqli($host, $user, $pw, $dbName);

if($mysqli){
    echo "MySQL successfully connected!<br/>";

    $temp1 = $_GET['temp1'];
    $humi1 = $_GET['humi1'];
    $weather = $_GET['weather'];
    $temp2 = $_GET['temp2'];
    $humi2 = $_GET['humi2'];

    echo "<br/>Temperature1 =" .$temp1;
    echo ", ";
    echo "Humidity1 =" .$humi1;
    echo ", ";
    echo "Weather =" .$weather;
    echo ", ";
    echo "Temperature2 =" .$temp2;
    echo ", ";
    echo "Humidity2 =" .$humi2;

    $query = "INSERT INTO TEM (temp1, humi1, weather,temp2,humi2) VALUES ('$temp1','$humi1','$weather','$temp2','$humi2')";

    mysqli_query($mysqli,$query); echo "</br>success!!"; }
    
    else{ echo "MySQL could not be connected"; } 
    mysqli_close($mysqli);
?>

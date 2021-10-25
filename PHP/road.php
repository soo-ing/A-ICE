<?php
    $con=mysqli_connect("localhost","hostsoo","ice135##","hostsoo");
    mysqli_set_charset($con,"utf8");

    $roadstate = $_POST['roadstate'];

    $query = "INSERT INTO ROAD(road_state) VALUES('".$roadstate."')";
    $res = mysqli_query($con,$query);

    echo $query;
    mysqli_close($con);
?>
<?php
    $con=mysqli_connect("localhost","hostsoo","ice135##","hostsoo");
    mysqli_set_charset($con,"utf8");

    $tem = $_POST['tem'];
   
    //echo $id

    $query1 = "select * from ".$tem;
    $res1 = mysqli_query($con,$query1);
    $result1 = array();

    
    while ($row1 = mysqli_fetch_array($res1)) {
        array_push($result1, 
            array('temp1'=>$row1[0],'humi1'=>$row1[1],'weather'=>$row1[2],'temp2'=>$row1[3],'humi2'=>$row1[4]));
    }

    $data1 = json_encode(array("arduino"=>$result1), JSON_UNESCAPED_UNICODE);
    echo $data1;

    mysqli_close($con);
?>
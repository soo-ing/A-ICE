<?php
    $con=mysqli_connect("localhost","hostsoo", "ice135##","hostsoo");
    mysqli_set_charset($con,"utf8");

    $query = "select * from ROAD order by count DESC limit 0, 5";
    $query1 = "select * from TEM order by count DESC limit 0, 5";
    $res = mysqli_query($con,$query);
    $res1 = mysqli_query($con,$query1);
    
    $count = 0;
    $countTemp = 0;
    $count2=0;

    if(mysqli_num_rows($res)){
        while($row = mysqli_fetch_assoc($res)){
            //echo "STATE: ".$row["road_state"]."<br>";
            if($row["road_state"]=='iceroad' || $row["road_state"]=='wetroad'){
                $count+=1;
            }
            
        }
    }else{
        echo "no data";
    }
    if($count >= 4){
        while($row1 = mysqli_fetch_assoc($res1)){
            //echo "dd: ".$row1["temp2"]-$row1["temp1"];
            if(($row1["temp1"]-$row1["temp2"]) >= 2){
                if(($row1["weather"]=='rainy') || ($row1["weather"]=='snow')){
                    $countTemp+=1;
                }
            }
        }
        if($countTemp >= 4) {
            echo "blackice,kpu";
   //echo json_encode(array("roadstate"=>array('state'=>'blackice')), JSON_UNESCAPED_UNICODE);
        }
        else echo "noblack,kpu";
    }else{
   while($row1 = mysqli_fetch_assoc($res1)){
      if(($row1["temp1"]-$row1["temp2"]) >= 2){
                      $count2+=1;
               }
   }
   if($count2>=4){
      echo "noblack,kpu";
   }else{
      echo "road,kpu";
   }   
}

    mysqli_close($con);
?>
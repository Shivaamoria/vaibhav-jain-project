
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<script src="https://www.w3schools.com/lib/w3.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">
<title>Friends Food Corner</title>
<style>
button{
font-size:20px;
border-radius:5px;
background-color:skyblue;
}
img{
width:150px;
height:150px;
}
p{
font-size:20px;
}
#myButton{
margin-left:calc(100% - 70px);

}
</style>
</head>
<body>
<div id="Menu" class="w3-container w3-black w3-xxlarge w3-padding-64"
style=background-image:url('images/rest.jpg');background-size:contain;>
<button onclick="location.href = 'Menu.jsp'" id="myButton" class=" submit-button" >Back</button>
<h1 class="w3-center w3-jumbo w3-padding-32"style=color:black;>North Indian</h1>

<div id="North Indian" class="w3-container w3-white w3-padding-32">

<form action="/cart">
<img alt="Samosa" src="images/samosa.jpg" loading="lazy" class="sc-s1isp7-5 fyZwWD">
<h1><b>Samosa</b>
 <span class="w3-right w3-tag w3-dark-grey w3-round">Rs. 25</span>
 </h1>
<p class="w3-text-grey">With Green Spicy chatni, Sweet Sauce</p>
<button type="submit" name="samosa" value="samosa">Add to cart</button>

<hr>
<img alt="Shahi Paneer" src="images/sahi paneer.jpg" loading="lazy" class="sc-s1isp7-5 fyZwWD">
<h1><b> Shahi Paneer</b> 
<span class="w3-right w3-tag w3-dark-grey w3-round">Rs. 55</span>
</h1>
<p class="w3-text-grey">With Paneer,Cream,Tomato,Spice</p>
<button type="submit" name="Shahi Paneer">Add to cart</button>
<hr>
<img alt="Chole Bhature" src="images/chole.jpg" loading="lazy" class="sc-s1isp7-5 fyZwWD">
<h1> 
<b>Chole Bhature</b> 
<span class="w3-right w3-tag w3-dark-grey w3-round">Rs. 100</span>
</h1>
   
<p class="w3-text-grey">Chole, 2 Full Bhature, Thin Sliced Onion</p>
<button type="submit" name="Chole Bhature">Add to cart</button>
<hr>
<img alt="Nandan Special" src="images/thali.jpg" loading="lazy" class="sc-s1isp7-5 fyZwWD">
<h1>
 <b>Veg Thali</b>
  <span class="w3-tag w3-red w3-round" style=font-size:20px;>Popular</span>
<span class="w3-right w3-tag w3-dark-grey w3-round">Rs. 250</span>
</h1>
<p class="w3-text-grey">Dal Makhni, Missi Roti, Naan, Chole, Rice, Raita, Salad</p>
<button type="submit" name="Veg Thali">Add to cart</button>
</div>
</form>
</div>
</body>
</html>
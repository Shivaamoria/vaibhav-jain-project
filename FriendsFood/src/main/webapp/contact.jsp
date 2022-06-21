<!DOCTYPE html>
<html lang="en">
  
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content=
        "width=device-width, initial-scale=1.0">
  
    <link rel="stylesheet" href="style.css">
    <title>ContactUs</title>
   
</head>
  
<body>
    <div id="ContactUs" style="height:750px;background-image:url('images/rest.jpg');background-size:cover">
       
        <form action="/contact" style= "height:500px;width:500px;background-color:#ffffff99;margin-top:100px;text-align:center; border-radius:10px">
         <h1 ><b><u>Contact Us</u></b></h1>
            <div class="form-shape">
                <label for="query">
                    Type of Query
                </label>
                <select name="myQuery" id="query">
                    <option value="sel" selected>
                        Select
                    </option>
                    <option value="ord">
                        Order related Issues
                    </option>
                    <option value="Site">
                        Site related Issues
                    </option>
                    <option value="fed">
                        Complaint related Issues
                    </option>
                    <option value="others">
                        Others
                    </option>
                </select>
            </div>
            <div class="form-shape">
                <label for="name">Name</label>
                <input type="text" name= "myName"
                   
                    placeholder="Enter your Name">
            </div>
            <div class="form-shape">
                <label for="email">Email-Id</label>
                <input type="email" name="myEmail" 
                    
                    placeholder="Enter your email">
            </div>
            <div class="form-shape">
                <label for="pho">Phone Number</label>
                <input type="phone" name="myPhone" 
                   
                    placeholder="Enter your Phone no">
            </div>
            
            <div class="form-shape">
                <label for="message">
                    Ellaborate your query
                </label>
                <textarea name="mesg" id="message" 
                    cols="30" rows="10">
                </textarea>
            </div>
            <input type="submit" >
            <input type="reset" >
        </form>
        </div>

</body>
  
</html>
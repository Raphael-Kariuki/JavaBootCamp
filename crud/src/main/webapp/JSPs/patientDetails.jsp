<%-- 
    Document   : patientDetails
    Created on : Dec 6, 2023, 11:05:37 AM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
              <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Patient details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    </head>
    <body>
    <nav class="navbar">
        <div class="container">
            <div class="row w-100">
                <div class="col-10 border border-3 border-dark">
                    <div class="row align-content-center">
                        <p class="text-start text-dark ">Welcome ${user.username}</p>

                    </div>
                </div>
                <div class="col-2 bg-dark">
                    <a href="/logout" class="text-center text-light">Logout</a>
                </div>
            </div>
        </div>
        
    </nav>
    <div class="container-fluid">
        <div class="row">
                   <div class="formLabel row mb-3">
                        <h2 class="text-center display-6">Patient registration form</h2> 
                    </div>
        </div>
        <div class="container-fluid">
                        <form class="row" action="" method="POST">

            <div class="col-6">
                    <fieldset >
                                                <legend>Primary details</legend>

                        <span class="d-block ">
                                <select class="col-2">
                            <option value="Select">Select</option>
                            <option value="Mr">Mr</option>
                            <option value="Mrs">Mrs</option>
                        </select>
                        </span>
                                                <label class="form-check-label" for="firstname">FirstName<b>*</b></label>
                       <input class="form-control mb-2" id="firstname" type="text" name="FirstName" placeholder="First Name"  required> 
                       <label class="form-check-label" for="loginusername">FirstName<b>*</b></label>
                       <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                       <label class="form-check-label" for="loginusername">FirstName<b>*</b></label>
                       <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                    
                   
                    </fieldset>
                    <fieldset >
                                                <legend>Contact details</legend>

                        <input class="form-control mb-2" list="datalistOptions" id="exampleDataList" placeholder="Type to search country...">
                            <datalist id="datalistOptions">
                              <option value="San Francisco">
                              <option value="New York">
                              <option value="Seattle">
                              <option value="Los Angeles">
                              <option value="Chicago">
                            </datalist>
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                        
                    
                   
                    </fieldset>
        
            </div>
            <div class="col-6">
                    <fieldset >
                                                <legend>Next of kin Primary details</legend>

                        <span class="d-block ">
                                <select class="col-2">
                            <option value="Select">Select</option>
                            <option value="Mr">Mr</option>
                            <option value="Mrs">Mrs</option>
                        </select>
                        </span>
                       <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                       <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                       <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                    
                   
                    </fieldset>
                    <fieldset >
                                                <legend>Next of kin Contact details</legend>
                                                 <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                             Similar to primary contacts
                            </label>

                        <input class="form-control mb-2" list="datalistOptions" id="exampleDataList" placeholder="Type to search country...">
                            <datalist id="datalistOptions">
                              <option value="San Francisco">
                              <option value="New York">
                              <option value="Seattle">
                              <option value="Los Angeles">
                              <option value="Chicago">
                            </datalist>
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                            <input class="form-control mb-2" id="loginusername" type="text" name="FirstName" placeholder="First Name"  required> 
                        
                    
                   
                    </fieldset>
        
                <div class="container">
                    
                </div>
            </div>
          

                
               
        

                                <div class="entriesSubmit row justify-items-center">
                                    <input  class="col-2 offset-5 btn btn-dark" type="submit" value="Submit">
                                </div>
                                 <div class="formLabel row mt-3">
                                     <a class="text-center text-light " href="/JSPs/signUp.jsp">Don't have an account, sign up</a> 
                                </div>

                            </form> 

        </div>
                    

    </div>

</body>
</html>

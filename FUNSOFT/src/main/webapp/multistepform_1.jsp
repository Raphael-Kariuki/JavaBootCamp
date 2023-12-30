<%-- 
    Document   : multistepform
    Created on : Dec 30, 2023, 5:42:00 PM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">



        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                background-color: #f1f1f1;
                height: 100vh;
            }
            header{
                position: fixed;
                top:0;
                left: 0;
                background: black;
                height: 50px;
                width: 100%;
            }

            nav{
                width: 100%;
                height: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
            }
            nav a{
                text-decoration: none;
                margin-left: 40px;
            }
            .container{
                position: relative;
                top: 60px;
                left: 0;
                right: 0;
                height: calc(100vh - 60px);
                display: grid;
                grid-template-columns: .9fr 11.1fr;
            }
            .steps{
                position: relative;
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                min-height: calc(100% - 10px);
                max-height: calc(100% - 10px);
                background: #04AA6D;
            }

            /* Make circles that indicate the steps of the form: */
            .step {
                height: 30px;
                width: 30px;
                background-color: #bbbbbb;
                border: none;
                border-radius: 50%;
                display: flex;
                opacity: 0.5;
                align-items:  center;
                justify-content: center;
                margin-left: 5px ;
            }
            .step.active {
                opacity: 1;
            }

            /* Mark the steps that are finished and valid: */
            .step.finish {
                background-color: #04AA6D;
            }






            #regForm {
                background-color: #ffffff;
                margin: auto;
                font-family: Raleway;
                padding: 40px;
                /*width: 70%;*/
                min-width: 300px;
                max-width: 600px;
                max-height: 98vh;
                overflow: auto;
            }
            .row{
                display: flex;
                justify-content: space-between;
                margin-bottom: 10px;
            }
            .row input{
                width: 75%;
            }

            h1 {
                text-align: center;
            }

            input {
                padding: 10px;
                width: 100%;
                font-size: 17px;
                font-family: Raleway;
                border: 1px solid #aaaaaa;
                border-radius: 5px;
            }

            /* Mark input boxes that gets an error on validation: */
            input.invalid {
                background-color: #ffdddd;
            }

            /* Hide all steps by default: */
            .tab {
                display: none;
            }

            button {
                background-color: #04AA6D;
                color: #ffffff;
                border: none;
                padding: 10px 20px;
                font-size: 17px;
                font-family: Raleway;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }

            #prevBtn {
                background-color: #bbbbbb;
            }




            /*            @media screen and (max-width: 600px){
                            .container{
                                display: grid;
                                grid-template-rows:  1fr 11fr;
                            }
                        .steps{
                         
                            flex-direction: row;
                            justify-content: space-around;
                        }
                        }*/
        </style>
    </head>
    <body>
        <header>
            <nav>
                <div class="menu-item">
                    <a href="#"><span></span>Home</a>

<!--TODO: steup drop down menu-->
                </div>
                <div class="menu-item">
                    <a href="#"><span></span>Gallery</a>

                </div>


            </nav>
        </header>
        <div class="container">
            <div class="steps">
<!--                TODO: setup layout as follows
                1: Set <p> opacity to match that of step
                2: Decorate font
                3: Align items-->
                <div class="div-step">
                    <p> Basic info</p>
                    <span class="step">1</span>
                </div>
                <div class="div-step">
                    <p> Basic info</p>
                    <span class="step">2</span>
                </div>
                <div class="div-step">
                    <p> Basic info</p>
                    <span class="step">3</span>

                </div>
                <div class="div-step">
                    <p> Basic info</p>
                    <span class="step">4</span>

                </div>


            </div>
            <form id="regForm" action="/action_page.php">
                <h1>Register:</h1>
                <!-- One "tab" for each step in the form: -->
                <div class="tab">Name:
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>
                    <div class="row">
                        <p><input placeholder="First name..." oninput="this.className = ''" name="fname"></p>
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="lname"></p>
                    </div>

                </div>
                <div class="tab">Contact Info:
                    <p><input placeholder="E-mail..." oninput="this.className = ''" name="email"></p>
                    <p><input placeholder="Phone..." oninput="this.className = ''" name="phone"></p>
                </div>
                <div class="tab">Birthday:
                    <p><input placeholder="dd" oninput="this.className = ''" name="dd"></p>
                    <p><input placeholder="mm" oninput="this.className = ''" name="nn"></p>
                    <p><input placeholder="yyyy" oninput="this.className = ''" name="yyyy"></p>
                </div>
                <div class="tab">Login Info:
                    <p><input placeholder="Username..." oninput="this.className = ''" name="uname"></p>
                    <p><input placeholder="Password..." oninput="this.className = ''" name="pword" type="password"></p>
                </div>
                <div style="overflow:auto;">
                    <div style="float:right;">
                        <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                        <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                    </div>
                </div>
                <!-- Circles which indicates the steps of the form: -->

            </form>

            <script>
                var currentTab = 0; // Current tab is set to be the first tab (0)
                showTab(currentTab); // Display the current tab

                function showTab(n) {
                    // This function will display the specified tab of the form...
                    var x = document.getElementsByClassName("tab");
                    x[n].style.display = "block";
                    //... and fix the Previous/Next buttons:
                    if (n === 0) {
                        document.getElementById("prevBtn").style.display = "none";
                    } else {
                        document.getElementById("prevBtn").style.display = "inline";
                    }
                    if (n === (x.length - 1)) {
                        document.getElementById("nextBtn").innerHTML = "Submit";
                    } else {
                        document.getElementById("nextBtn").innerHTML = "Next";
                    }
                    //... and run a function that will display the correct step indicator:
                    fixStepIndicator(n);
                }

                function nextPrev(n) {
                    // This function will figure out which tab to display
                    var x = document.getElementsByClassName("tab");
                    // Exit the function if any field in the current tab is invalid:
                    if (n === 1 && !validateForm())
                        return false;
                    // Hide the current tab:
                    x[currentTab].style.display = "none";
                    // Increase or decrease the current tab by 1:
                    currentTab = currentTab + n;
                    // if you have reached the end of the form...
                    if (currentTab >= x.length) {
                        // ... the form gets submitted:
                        document.getElementById("regForm").submit();
                        return false;
                    }
                    // Otherwise, display the correct tab:
                    showTab(currentTab);
                }

                function validateForm() {
                    // This function deals with validation of the form fields
                    var x, y, i, valid = true;
                    x = document.getElementsByClassName("tab");
                    y = x[currentTab].getElementsByTagName("input");
                    // A loop that checks every input field in the current tab:
                    for (i = 0; i < y.length; i++) {
                        // If a field is empty...
                        if (y[i].value === "") {
                            // add an "invalid" class to the field:
                            y[i].className += " invalid";
                            // and set the current valid status to false
                            valid = false;
                        }
                    }
                    // If the valid status is true, mark the step as finished and valid:
                    if (valid) {
                        document.getElementsByClassName("step")[currentTab].className += " finish";
                    }
                    return valid; // return the valid status
                }

                function fixStepIndicator(n) {
                    // This function removes the "active" class of all steps...
                    var i, x = document.getElementsByClassName("step");
                    for (i = 0; i < x.length; i++) {
                        x[i].className = x[i].className.replace(" active", "");
                    }
                    //... and adds the "active" class on the current step:
                    x[n].className += " active";
                }
            </script>
        </div>
    </body>
</html>


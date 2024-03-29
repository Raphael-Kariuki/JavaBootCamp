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
                text-decoration: none;
            }

            body {
                background-color: #f1f1f1;
                height: 100vh;
            }
            header{
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                background: white;
                display: flex;
                justify-content: space-between;
                align-items: center;
                z-index: 1000;
            }
            header .logo{
                font-weight: bolder;
                font-size: 25px;
                color: #333;
            }
            header .navbar ul{
                list-style: none;
            }
            header .navbar ul li{
                position: relative;
                float: left;
            }
            header .navbar ul li a{
                font-size: 20px;
                padding: 20px;
                color: #333;
                display: block;
            }
            header .navbar ul li a:hover{
                background: #333;
                color: #fff;
            }
            header .navbar ul li ul{
                position: absolute;
                left: 0;
                width: 200px;
                background: #fff;
                display: none;
            }
            header .navbar ul li ul li{
                width: 100%;
                border-top: 1px solid rgba(0,0,0,0.1);
            }
            header .navbar ul li ul li ul{
                left: 200px;
                top:0;
            }
            header .navbar ul li:focus-within > ul,
            header .navbar ul li:hover > ul{
                display: initial;
            }
            #menu-bar{
                display: none;
            }
            header label{
                font-size: 20px;
                color: #333;
                cursor: pointer;
                display: none;
            }

            @media(max-width: 991px){
                header{
                    padding: 20px;

                }
                header label{
                    display: initial;

                }
                header .navbar{
                    position: absolute;
                    top: 100%;
                    left: 0;
                    right: 0;
                    background: #fff;
                    border-top: 1px solid rgba(0,0,0,0.1);
                    display:none;
                }
                header .navbar ul li{
                    width: 100%;
                }
                header .navbar ul li ul{
                    position: relative;
                    width: 100%;
                }
                header .navbar ul li ul li{
                    background: #eee;
                    width: 90%;
                    left: 10%;
                }
                #menu-bar:checked ~ .navbar{
                    display: initial;
                }
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
                border:1px solid #04AA6D;
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
            <a  class="logo" href="#"> Logo</a>
            <input type="checkbox" id="menu-bar">
            <label for="menu-bar">Menu</label>
            <nav class="navbar">
                <ul>
                    <li><a href="">Home</a></li>
                    <li><a href="">Services +</a>
                        <ul>
                            <li><a href="">Citizen</a></li>
                            <li><a href="">Non-Citizen</a></li>
                            <li><a href="">Foreigner+</a>
                                <ul>
                                    <li><a href="">Australia</a></li>
                                    <li><a href="">American</a></li>
                                    <li><a href="">European</a></li>

                                </ul>

                            </li>

                        </ul>

                    </li>
                    <li><a href="">Gallery+</a>
                        <ul>
                            <li><a href="">Grid Gallery</a></li>
                            <li><a href="">Flex Gallery</a></li>

                        </ul>

                    </li>
                    <li><a href="">About us</a></li>
                    <li><a href="">contact us</a></li>
                </ul>

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
                    <p> Contact info</p>
                    <span class="step">2</span>
                </div>
                <div class="div-step">
                    <p> Location info</p>
                    <span class="step">3</span>

                </div>
                <div class="div-step">
                    <p> Patient Other Details</p>
                    <span class="step">4</span>

                </div>
                <div class="div-step">
                    <p> Next of Kin info</p>
                    <span class="step">5</span>

                </div>
                <div class="div-step">
                    <p> Referral Details</p>
                    <span class="step">6</span>

                </div>


            </div>
            <form id="regForm" action="/action_page.php"  >
                <!-- One "tab" for each step in the form: -->
                <div class="tab">
                    <div class="row">
                        <div class="inputs">
                            <label for="ptRegServicePoint">Registration Service Point</label>
                            <select  id="ptRegServicePoint" name="ptRegServicePoint" required >
                                <option value="">Select</option>
                                <option value="In-Patient">In-Patient</option>
                                <option value="Out-Patient">Out-Patient</option>
                            </select>
                        </div>
                        <div class="inputs">
                            <label for="ptUrgency">Patient Urgency</label>
                            <select  id="ptUrgency" name="ptUrgency" required >
                                <option value="">Select</option>
                                <option value="Normal">Normal</option>
                                <option value="Emergency">Emergency</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <p><input placeholder="Last name..." oninput="this.className = ''" name="ptLname"></p>
                        <p><input placeholder="Other names..." oninput="this.className = ''" name="ptOtherNames"></p>
                    </div>
                    <div class="row">
                        <div class="inputs">
                            <label for="specialtyClinic">Specialty Clinic</label>
                            <select  id="specialtyClinic" name="specialtyClinic" required >
                                <option value="">Select</option>
                                <option value="Casualty">Casualty</option>
                                <option value="Clinics">Clinics</option>
                                <option value="Consultation">Consultation</option>
                                <option value="Dental">Dental</option>
                                <option value="Dopc">Dopc</option>
                                <option value="Ent">Ent</option>
                                <option value="Eye">Eye</option>
                            </select>   
                        </div>
                        <p><input placeholder="C Sheet Number..." oninput="this.className = ''" name="ptCSheetNo"></p>
                    </div>
                    <div class="row">
                        <div class="inputs">
                            <label>Gender</label>


                            <label for="ptGenderM">
                                <input id="ptGenderM" type="radio"  name="ptGender"/>
                                Male     
                            </label>
                            <label for="ptGenderF">
                                <input id="ptGenderF" type="radio"  name="ptGender"/>
                                Female     
                            </label>
                        </div>
                        <div class="inputs maritalStatus    ">
                            <label >Marital status </label>

                            <label for="ptMaritalStatusS">
                                <input id="ptMaritalStatusS" type="radio"  name="ptMaritalStatus"/>

                                Single  </label>

                            <label for="ptMaritalStatusM">
                                <input id="ptMaritalStatusM" type="radio"  name="ptMaritalStatus"/>

                                Married  </label>


                            <label for="ptMaritalStatusD">
                                <input id="ptMaritalStatusD" type="radio"  name="ptMaritalStatus"/>

                                Divorced </label>

                            <label for="ptMaritalStatusW">
                                <input id="ptMaritalStatusW" type="radio"  name="ptMaritalStatus"/>

                                Widowed</label>

                        </div>
                    </div>
                    <div class="row">
                        <div class="inputs">
                            <label for="ptAge">Age
                                <input id="ptAge" type="text"  name="ptAge" readonly/>
                            </label>
                        </div>
                        <div class="inputs">
                            <label for="ptDOB"> Date of Birth 
                                <sup>*</sup>
                                <input id="ptDOB" type="date"  name="ptDOB" required />

                            </label>

                        </div>
                    </div>
                    <div class="row">
                        <div class="inputs">
                            <label> Patient with disability  </label>
                            <select  id="ptDisabled" name="ptDisabled" required >
                                <option value="">Select</option>
                                <option value="Yes">Yes</option>
                                <option value="No">No</option>
                            </select>

                        </div>
                        <div class="inputs">
                            <label for="ptAuthority">Authority</label>
                            <select  id="ptAuthority" name="ptAuthority" required >
                                <option value="">Select</option>
                                <option value="Voluntary">Voluntary</option>
                                <option value="Involuntary">Involuntary</option>


                            </select>
                        </div>
                    </div>

                </div>
                <div class="tab">Contact Info:
                    <p><input placeholder="ID Number..." oninput="this.className = ''" name="ptIDNo"></p>
                    <p><input placeholder="E-mail..." oninput="this.className = ''" name="ptEmailAddress"></p>
                    <p><input placeholder="Phone..." oninput="this.className = ''" name="ptPhoneNumber"></p>
                </div>
                <div class="tab">Patient residence details:
                    <div class="inputs">
                        <label for="ptNationality">Nationality</label>
                        <select  id="ptNationality" name="ptNationality" required >
                            <option value="">Select</option>
                            <option value="Kenya">Kenya</option>
                            <option value="Uganda">Uganda</option>

                        </select>
                    </div>
                    <div class="inputs">
                        <label for="ptCounty">County</label>
                        <select  id="ptCounty" name="ptCounty" required >
                            <option value="">Select</option>
                            <option value="Garissa">Garissa</option>
                        </select>
                    </div>

                    <div class="inputs">
                        <label for="ptSubCounty">Sub County</label>
                        <select  id="ptSubCounty" name="ptSubCounty" required >
                            <option value="">Select</option>
                            <option value="Igoji">Igoji</option>
                        </select>
                    </div>
                    <p><input placeholder="Postal address" oninput="this.className = ''" name="ptPostalAddress"></p>
                    <p><input placeholder="Home Village" oninput="this.className = ''" name="ptHomeVillage"></p>
                    <p><input placeholder="Physical residence" oninput="this.className = ''" name="ptPhysicalResidence"></p>
                    <p><input placeholder="Place of Birth" oninput="this.className = ''" name="ptPlaceOfBirth"></p>
                </div>
                <div class="tab">Patient other Details:
                    <div class="inputs">
                        <label class="form-control" >
                            <input id="ptNHIFRegistered" type="checkbox"  name="ptNHIFRegistered"/>
                            NHIF registered
                        </label>
                        <input id="ptNHIFRegisteredChildren" type="text"  name="ptNHIFRegisteredChildren" placeholder="No of children"/>
                    </div>
                    <p><input placeholder="NHIF claim number" oninput="this.className = ''" type="text" name="ptNHIFClaimNo"></p>
                    <p><input placeholder="Old file number" oninput="this.className = ''" type="text" name="ptOldFileNumber"></p>
                    <p><input placeholder="Other numbers" oninput="this.className = ''" type="text" name="ptOtherNo"></p>
                </div>
                <div class="tab">Next of kin details:
                    <div class="inputs"> 
                        <input id="ptBroughtByNOK" type="radio"   value="NOK" name="ptBroughtBy"/>
                        <label for="ptBroughtByNOK"> Next of Kin </label>
                        <input id="ptBroughtByGoodSamaritan" type="radio" value="GoodSamaritan"  name="ptBroughtBy"/>
                        <label for="ptBroughtByGoodSamaritan"> Good samaritan </label>

                    </div>
                    <p><input placeholder="NOK Full Name..." oninput="this.className = ''" name="ptNOKFullName" type="text"></p>
                    <p><input placeholder="NOK Relation..." oninput="this.className = ''" name="ptNOKRelation" type="text"></p>
                    <p><input placeholder="NOK ID/Passport No..." oninput="this.className = ''" name="ptNOKID_PassportNo" type="text"></p>
                    <p><input placeholder="NOK Phone No..." oninput="this.className = ''" name="ptNOKPhoneNo" type="tel"></p>
                    <p><input placeholder="NOK Postal Address..." oninput="this.className = ''" name="ptNOKPostalAddress" type="text"></p>
                    <p><input placeholder="NOK Physical Residence..." oninput="this.className = ''" name="ptNOKPhysicalResidence" type="text"></p>
                </div>
                <div class="tab">Referral Details:
                    <p><input placeholder="Referral type..." oninput="this.className = ''" name="ptReferralType"></p>
                    <p><input placeholder="Referral Facility.." oninput="this.className = ''" name="ptReferralfacility"></p>
                    <p><input placeholder="Referral County..." oninput="this.className = ''" name="ptRReferralCounty"></p>
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
//                    if (n === 1 && !validateForm())
//                        return false;
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


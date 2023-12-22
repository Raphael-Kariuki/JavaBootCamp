<%-- 
    Document   : opdRegistration
    Created on : Dec 22, 2023, 5:12:46 PM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="">
            <div>
                <fieldset>
                    <label for="newPtCard">
                        <input id="newPtCard" type="radio" value="newPtCard" name="PtCard"/>
                        Create new patient file
                    </label>
                    <label for="oldPtCard">
                        <input id="oldPtCard" type="radio" value="oldPtCard" name="PtCard"/>
                        Create old patient file
                    </label>
                    <label for="revist">
                        <input id="revist" type="radio" value="revist" name="PtCard"/>
                        Revisit
                    </label>
                    <label for="reprintFile">
                        <input id="reprintFile" type="radio" value="reprintFile" name="reprintFile"/>
                        Reprint File
                    </label>
                    <label for="ptCategory">     Patient Category
                    </label>
                    <select  id="ptCategory" name="ptCategory">
                        <option value="">Select</option>
                        <option value="Casualty">Casualty</option>
                        <option value="General">General</option>
                        <option value="Prisoner">Prisoner</option>
                        <option value="Psychiatry">Psychiatry</option>
                        <option value="RTA">RTA</option>
                        <option value="Scheme">Scheme</option>
                        <option value="SGBV">SGBV</option>
                    </select>
                </fieldset>


            </div>
            <div>
                <fieldset>
                    <label for="searchByPtNo">
                        <input id="searchByPtNo" type="checkbox" value="searchByPtNo" name="searchByPtNo"/>
                        Search by Patient Number
                    </label> 
                    <label for="searchByPtName">
                        <input id="searchByPtName" type="checkbox" value="searchByPtName" name="searchByPtName"/>
                        Search by Patient Name
                        <input id="searchByPtNameInput" type="text"  name="searchByPtNameInput"/>
                    </label> 
                    <label for="currVisitDate">   Current visit Date
                    </label> 
                    <input id="currVisitDate" type="date"  name="currVisitDate" readonly/>
                    <label for="todayVisitDate">   Appointment visit Date
                    </label> 
                    <input id="todayVisitDate" type="date"  name="todayVisitDate"/>


                </fieldset>

            </div>
            <div>
                <fieldset>
                    <legend>You can search by Adm No./Pt No./Id No./Phone No./ NOK details</legend>

                    <label for="searchByPtNo_ID_Input">   Pt No/ID
                    </label> 
                    <input id="searchByPtNo_ID_Input" type="text"  name="searchByPtNo_ID_Input"/>
                    <label for="searchByPtFromIPInput">   Search from IP
                    </label> 
                    <input id="searchByPtFromIPInput" type="text"  name="searchByPtFromIPInput"/>

                    <label for="PayMode">     Payment Mode
                    </label>
                    <select  id="PayMode" name="PayMode" required>
                        <option value="">Select</option>
                        <option value="Cash">Cash</option>
                        <option value="Cheque">Cheque</option>
                        <option value="Credit Card">Credit Card</option>
                        <option value="EFT">EFT</option>
                        <option value="Flutterwave">Flutterwave</option>
                        <option value="Googlepay">Googlepay</option>
                        <option value="Mpesa">Mpesa</option>
                        <option value="Paybill">Paybill</option>
                    </select>
                    <label for="ptBranch">   Branch
                    </label> 
                    <input id="ptBranch" type="text"  name="ptBranch"/>
                </fieldset>

            </div>
            <div>
                <fieldset>
                    <a class="tablink" onclick="openPage('ptBioData', this, 'red')" id="defaultOpen" >Patient Bio Data</a>
                    <a class="tablink" onclick="openPage('demographics', this, 'green')" >Demographic Info</a>
                    <a class="tablink" onclick="openPage('ptInsuranceDetails', this, 'blue')">Insurance Details</a>
                    <a class="tablink" onclick="openPage('ptCreditDetails', this, 'orange')">Credit card details</a>
                    <a class="tablink" onclick="openPage('rta', this, 'orange')">RTA</a>
                    <a class="tablink" onclick="openPage('ptDiagnosis', this, 'orange')">Diagnosis</a>
                    <a class="tablink" onclick="openPage('registedPts', this, 'orange')">Report of registered patients</a>
                    <a class="tablink" onclick="openPage('spatialData', this, 'orange')">Spatial Info/GIS Map</a>
                    <a class="tablink" onclick="openPage('ptPreviousVisits', this, 'orange')">Previous visits</a>
                    <a class="tablink" onclick="openPage('ptVitalsSigns', this, 'orange')">Vital signs</a>

                    <div id="ptBioData" class="tabcontent">
                        <h3>Patient Bio Data</h3>
                        <fieldset>
                            <div>
                                <label for="ptUrgency">     Patient Urgency
                                </label>
                                <select  id="ptUrgency" name="ptUrgency" required >
                                    <option value="Normal">Normal</option>
                                    <option value="Emergency">Emergency</option>

                                </select>
                            </div>
                            <div>
                                <label for="ptSurnameLastname">
                                    Patient Surname/Lastname

                                    <input id="ptSurnameLastname" type="text"  name="ptSurnameLastname"/>
                                </label>
                            </div>
                            <div>
                                <label for="ptOthernames">
                                    Other patient names

                                    <input id="ptOthernames" type="text"  name="ptOthernames"/>
                                </label>
                            </div>

                            <div>
                                <label for="specialtyClinic">    Specialty Clinic
                                </label>
                                <select  id="specialtyClinic" name="specialtyClinic" required >
                                    <option value="Casualty">Casualty</option>
                                    <option value="Clinics">Clinics</option>
                                    <option value="Consultation">Consultation</option>
                                    <option value="Dental">Dental</option>
                                    <option value="Dopc">Dopc</option>
                                    <option value="Ent">Ent</option>
                                    <option value="Eye">Eye</option>

                                </select>
                            </div>
                            <div>
                                <label for="ptCSheetNo">
                                    C-Sheet Number

                                    <input id="ptCSheetNo" type="text"  name="ptCSheetNo"/>
                                </label>
                            </div>
                            <span>
                                <label for="ptGender">
                                    Gender(Tick only one)                                </label>

                                <span id="ptGender">

                                    <label for="ptGenderM">
                                        <input id="ptGenderM" type="radio"  name="ptGender"/>
                                        Male     
                                    </label>
                                    <label for="ptGenderF">
                                        <input id="ptGenderF" type="radio"  name="ptGender"/>
                                        Female     
                                    </label>
                                </span>

                            </span>
                            <div>
                                <label for="ptMaritalStatus">
                                    Marital status                                </label>

                                <span id="ptMaritalStatus">

                                    <label for="ptMaritalStatusS">
                                        <input id="ptMaritalStatusS" type="radio"  name="ptMaritalStatus"/>
                                        Single     
                                    </label>
                                    <label for="ptMaritalStatusM">
                                        <input id="ptMaritalStatusM" type="radio"  name="ptMaritalStatus"/>
                                        Married     
                                    </label>



                                    <label for="ptMaritalStatusD">
                                        <input id="ptMaritalStatusD" type="radio"  name="ptMaritalStatus"/>
                                        Divorced     
                                    </label>
                                    <label for="ptMaritalStatusW">
                                        <input id="ptMaritalStatusW" type="radio"  name="ptMaritalStatus"/>
                                        Widowed     
                                    </label>

                                </span>

                            </div>
                            <div>
                                <label for="ptAge">
                                    Age   

                                    <input id="ptAge" type="text"  name="ptAge" readonly/>
                                </label>
                            </div>
                            <div>
                                <label for="ptDOB">
                                    Date of Birth  

                                    <input id="ptDOB" type="date"  name="ptDOB" required/>
                                </label>
                            </div>
                            <div>
                                <label for="ptWithDisability">
                                    Patient with disability 

                                    <span id="ptWithDisability">
                                        <select  id="ptDisabled" name="ptDisabled" required >
                                            <option value="Yes">Yes</option>
                                            <option value="No">No</option>


                                        </select>
                                        <select  id="ptAuthority" name="ptAuthority" required >
                                            <option value="Voluntary">Voluntary</option>
                                            <option value="Involuntary">Involuntary</option>


                                        </select>
                                    </span>
                                </label>
                            </div>

                        </fieldset>
                        <fieldset>
                            <div>
                                <label for="ptIdPassportNo">
                                    ID/Passport No.

                                    <input id="ptIdPassportNo" type="text"  name="ptIdPassportNo"/>
                                </label>
                            </div>
                            <div>
                                <label for="ptPhoneNo">
                                    Phone No.

                                    <input id="ptPhoneNo" type="text"  name="ptPhoneNo"/>
                                </label>
                            </div>
                            <div>
                                <label for="ptNationality">Nationality</label>
                                <select  id="ptAuthority" name="ptAuthority" required >
                                    <option value="Kenya">Kenya</option>
                                    <option value="Uganda">Uganda</option>


                                </select>
                            </div>
                            <div>
                                <label for="ptCounty">County</label>
                                <select  id="ptCounty" name="ptCounty" required >
                                    <option value="Meru">Meru</option>
                                    <option value="Garissa">Garissa</option>


                                </select>
                            </div>
                            <div>
                                <label for="ptSubCounty">Sub County</label>
                                <select  id="ptSubCounty" name="ptSubCounty" required >
                                    <option value="Igoji">Igoji</option>


                                </select>
                            </div>
                            <div>
                                <label for="ptEmailAddr">
                                    Email address

                                    <input id="ptEmailAddr" type="email"  name="ptEmailAddr"/>
                                </label>
                            </div>
                            <div>
                                <label for="ptPostalAddr">
                                    Postal address

                                    <input id="ptPostalAddr" type="text"  name="ptPostalAddr"/>
                                </label>
                            </div>
                            <div>
                                <label for="ptHomeVillage">
                                    Home Village

                                    <input id="ptHomeVillage" type="text"  name="ptHomeVillage"/>
                                </label>
                            </div>
                            <div>
                                <span>
                                    <label>NHIF registered</label>
                                    <input id="ptNHIFRegistered" type="checkbox"  name="ptNHIFRegistered"/>
                                    <input id="ptNHIFRegisteredChildren" type="text"  name="ptNHIFRegisteredChildren" placeholder="No of children"/>
                                </span>
                            </div>
                            <div>
                                <label for="ptNHIFClaimNo">
                                    NHIF Claim Number

                                    <input id="ptNHIFClaimNo" type="text"  name="ptNHIFClaimNo"/>
                                </label>
                            </div>
                        </fieldset>

                    </div>
                    <div id="demographics" class="tabcontent">
                        <h3>Demographic Info</h3>

                    </div>
                    <div id="ptInsuranceDetails" class="tabcontent">
                        <h3>Insurance Details</h3>

                    </div>
                    <div id="ptCreditDetails" class="tabcontent">
                        <h3>Credit card details</h3>

                    </div>
                    <div id="rta" class="tabcontent">
                        <h3>RTA</h3>

                    </div>
                    <div id="ptDiagnosis" class="tabcontent">
                        <h3>Diagnosis</h3>

                    </div>
                    <div id="registedPts" class="tabcontent">
                        <h3>Report of registered patients</h3>

                    </div>
                    <div id="spatialData" class="tabcontent">
                        <h3>Spatial Info/GIS Map</h3>

                    </div>
                    <div id="ptPreviousVisits" class="tabcontent">
                        <h3>Previous visits</h3>

                    </div>
                    <div id="ptVitalsSigns" class="tabcontent">
                        <h3>Vital signs</h3>

                    </div>


                    <script>
                        function openPage(pageName, elmnt, color) {
                            var i, tabcontent, tablinks;
                            tabcontent = document.getElementsByClassName("tabcontent");
                            for (i = 0; i < tabcontent.length; i++) {
                                tabcontent[i].style.display = "none";
                            }
                            tablinks = document.getElementsByClassName("tablink");
                            for (i = 0; i < tablinks.length; i++) {
                                tablinks[i].style.backgroundColor = "";
                            }
                            document.getElementById(pageName).style.display = "block";
                            elmnt.style.backgroundColor = color;
                        }

                        // Get the element with id="defaultOpen" and click on it
                        document.getElementById("defaultOpen").click();
                    </script>
                </fieldset>
            </div>
        </form>
    </body>
</html>

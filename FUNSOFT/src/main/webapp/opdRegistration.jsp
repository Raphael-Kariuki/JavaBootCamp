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
                        <input id="newPtCard" type="radio" value="newPtCard" name="newPtCard"/>
                        Create new patient file
                    </label>
                    <label for="oldPtCard">
                        <input id="oldPtCard" type="radio" value="oldPtCard" name="oldPtCard"/>
                        Create old patient file
                    </label>
                    <label for="revist">
                        <input id="revist" type="radio" value="revist" name="revist"/>
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
                    <input id="currVisitDate" type="date"  name="currVisitDate"/>
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
                    <select  id="PayMode" name="PayMode">
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
                    <a class="tablink" onclick="openPage('ptBioData', this, 'red')">Patient Bio Data</a>
                    <a class="tablink" onclick="openPage('demographics', this, 'green')" id="defaultOpen">Demographic Info</a>
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

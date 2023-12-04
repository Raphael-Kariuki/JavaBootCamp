<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Populate table</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
        
    </head>
    <body>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" 
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
        crossorigin="anonymous"></script>
        <script>
              function handleError(err) {
                console.log("OH NO!");
                console.log(err);
              }
            const endpoint = "http://localhost:8081/webapi/person/all/get";
            const wesPromise = fetch(endpoint);

            wesPromise
                    .then((response) => response.json())
              .then((data) => {
                    var table = "";

                  for(var i = 0;i < data.length; i++){
                      var firstName = data[i].firstname;
                      var lastName = data[i].lastname;
                      var age = data[i].age;
                      var height = data[i].height;
                      
                      console.log(firstName +""+lastName+""+age+""+height);
                      table += "<tr>";
                      table += "<td>"+firstName+"</td>";
                      table += "<td>"+lastName+"</td>";
                      table += "<td>"+age+"</td>";
                      table += "<td>"+height+"</td>";
                      
                      table += "</tr>";
                      
                  }
                  document.getElementById("results").innerHTML = table;
                  
      })
              .catch(handleError);
        </script>
   


    <nav class="navbar">
        <div class="container-fluid">
            <p>Populate table</p>
        </div>
        
    </nav>
    <div class="col">
        <div class="col-4 bg-secondary"></div>
        <div class="col-8 bg-primary">
            <p id="errorDisplay"></p>
            <table class="table table-bordered">
                <thead class="alert-info">
                    <tr>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Age</th>
                        <th>Height</th>
                    </tr>
                </thead>
                <tbody id="results"></tbody>
            </table>
        </div>
    </div>

</body>
</html>

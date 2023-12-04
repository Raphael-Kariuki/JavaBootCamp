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
           //ES6 class that takes a url as input and does a delete request to the url. Hits @Delete web api
              class DeleteHTTP{
                async delete(url){
                    //awaiting fetch
                    const response = await fetch(url, 
                    {
                        method: 'DELETE',
                        headers: {
                            'Content-type': 'application/json'
                        }
                    });
                    //define variable to return when async function takes long to return response. if quick wont be shown
                    const resData = 'resource deleted ...';
                    return resData;
                }
              }
              //function that is called to create an instance of the ES6 class and execute the async method within, 
              //that is supplied with a URI - web api uri that when hit deletes a record from db 
              //based on the argument(id) placed /webapi/person/{id}/delete
              // ---------------
              //function is called when the dynamic <a> tag is clicked with the innerText delete
              function actualDeletion(){
                    const http = new DeleteHTTP;
              
              http.delete('/webapi/person/4/delete')
              //on success the dom is reloaded to repopulate the table with remaining records
                      .then(() => window.location.reload())
              //on error log the error
                      .catch(err => console.log(err));
              }
            
         
         //create url
            const endpoint = "/webapi/person/all/get";
            //perform a get request
            const wesPromise = fetch(endpoint);

            wesPromise
            //the response has so much, processing is required before proper use, that's why multiple .then
                    .then((response) => response.json())
                    .then((data) => {
                        //initialize a table building string and build upon it slowly
                    var table = "";
                    //iterate through the data element and assign the required fields
                  for(var i = 0;i < data.length; i++){
                      var firstName = data[i].firstname;
                      var lastName = data[i].lastname;
                      var age = data[i].age;
                      var height = data[i].height;
                      var entryId = data[i].entryid;
                      
//                      console.log(firstName +""+lastName+""+age+""+height);
                    //create a table row dynamically. Number of rows will be based on the length of return objects
                      table += "<tr>";
                      
                      table += "<td>"+entryId+"</td>";
                      table += "<td>"+firstName+"</td>";
                      table += "<td>"+lastName+"</td>";
                      table += "<td>"+age+"</td>";
                      table += "<td>"+height+"</td>";
                      //TODO - Delete <a> is handled, handle view <a> tag to redirect to a page that will be populated with the entire object details
                      //editing can then be done. Currently delete is based on hard-coding the {id} value which is the entryId currently.
                      //Plan is to 
                      /* 1: When selecting from db in service class, select even the entryId which will be passed along and also populated
                       *    on the table
                       * 2: The entry id can then be used by passing it dynamically to the url
                       * 
                       * 
                       */
                      
                      //<a> delete calls a delete function that hits the delete api onClick()
                      table += '<td><a href="#">View</a> | <a href="" onclick="actualDeletion()">Delete</a></td>';
                      
                      table += "</tr>";
                      
                  }
                  document.getElementById("results").innerHTML = table;
                  
      })
              .catch((err) => console.log(err));
      
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
                        <th>EntryId</th>
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

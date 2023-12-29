<%-- 
    Document   : temp3
    Created on : Dec 27, 2023, 10:55:30 AM
    Author     : mo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            body{
                height: 100vh;
                width: 100%;
                background: white;
            }
            header{
                position: relative;
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
            .steps-container{
                position: relative;
                width: 100%;
                height: 200px;
                background: linear-gradient(to left, #2193b0,#6dd5ed);
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
            }
            .steps{
                position: relative;
                width: 80%;
                height: 100px;
                /*background: white;*/
                display: flex;
                align-items: center;
                justify-content: space-between;
            }
            .steps span{
                width: 50px;
                height: 50px;
                border-radius: 50%;
                border: 4px solid #e7e9bb;
                background: white;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 18px;
                font-weight: 800;
                z-index: 1;

            }
            span.active{
                border: 4px solid blue;
            }
            .progress-bar{
                position: absolute;
                width: 100%;
                height: 4px;
                background: #e7e9bb;
                z-index: 0;
            }
            .progress-bar .indicator{
                position: absolute;
                width: 0%;
                height: 4px;
                background: blue;
                /*z-index: 0;*/
            }
            .buttons{
                display: flex;
                flex-direction: row;
                gap: 20px;
            }
            .buttons button{
                cursor: pointer;
                background:rgba(0,0,0,1);
                color: white;
                padding:  5px 10px;
                border-radius: 5px;
                border: none;
                box-shadow:  0 5px 10px rgba(0,0,0,0.5);
            }
            button:disabled{
                background: rgba(0,0,0,.5);
                cursor: not-allowed;
            }

        </style>

    </head>
    <body>
        <header>
            <nav>
                <div class="menu-item">
                    <a href="#"><span></span>Home</a>
                    <span class="left-icon"></span>
                    <span class="right-icon"></span>

                </div>
                <div class="menu-item">
                    <a href="#"><span></span>Gallery</a>
                    <span class="left-icon"></span>
                    <span class="right-icon"></span>
                </div>


            </nav>
        </header>
        <div class="steps-container">
            <div class="steps">
                <span class="circle active ">1</span>
                <span class="circle">2</span>
                <span class="circle">3</span>
                <span class="circle">4</span>
                <div class="progress-bar">
                    <div class="indicator"></div>
                </div>
            </div>
            <div class="buttons">
                <button id="prev" disabled >Prev</button>
                <button id="next">Next</button>
            </div>
        </div>
        <script>
            const circles = document.querySelectorAll(".circle"),
                    progressBar = document.querySelector(".indicator"),
                    buttons = document.querySelectorAll("button");

            let currentStep = 1;
            const analyzeStep = (event) => {

                //if event source is btn with id set to next, increment currentStep
                currentStep = event.target.id === "next" ? ++currentStep : --currentStep;

                //if the index of the circle is less than the current step, 
                //add the active class so that css come's to play
                circles.forEach((circle, index) => {
                    const action = index < currentStep ? "add" : "remove";
                    circle.classList[action]("active");
                });
                const length = (currentStep - 1) / (circles.length - 1) * 100;
                progressBar.style.width = length + '%';
                
                if(currentStep === 1){
                    buttons[0].disabled = true;
                }else if(currentStep === circles.length){
                    buttons[1].disabled = true;
                }else{
                    buttons.forEach((button) => {
                        button.disabled = false;
                    });
                }
            };
            buttons.forEach((button) => {
                button.addEventListener('click', analyzeStep);
            });

        </script>
    </body>
</html>

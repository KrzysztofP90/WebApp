

function addListeners() {
    document.getElementById("menu-icon").addEventListener("click",showMenuAndHideRest);
    document.getElementById("back-to-main").addEventListener("click",backToMain);
    document.getElementById("about-us").addEventListener("click",showAboutUs);
    document.getElementById("roofs").addEventListener("click",showRoofs);
    document.getElementById("hydro").addEventListener("click",showHydro);


}


function showMenuAndHideRest() {

    document.getElementById("navbar").setAttribute("style","display:flex");


    document.getElementById("menu-icon").setAttribute("style","display:none");

    document.getElementById("logo").setAttribute("style","justify-content:center");

    document.getElementById("introduction").setAttribute("style","display:none");


    document.getElementById("roll-menu").setAttribute("style","transition:3s");
    document.getElementById("roll-menu").setAttribute("style","border:solid");
    document.getElementById("roll-menu").setAttribute("style","border-color:aliceblue");
    document.getElementById("roll-menu").setAttribute("style","height:500px");

    document.getElementById("back-to-main").setAttribute("style","display:flex");

    document.getElementById("content").setAttribute("style","min-height: 100px");

}



function backToMain() {

    document.getElementById("back-to-main").setAttribute("style","display:none");


    document.getElementById("roll-menu").setAttribute("style","border:none");
    document.getElementById("roll-menu").setAttribute("style","height:0px");

    document.getElementById("navbar").setAttribute("style","display:none");

    document.getElementById("menu-icon").setAttribute("style","display:flex");

    document.getElementById("logo").setAttribute("style","justify-content:left");

    document.getElementById("introduction").setAttribute("style","display:block");

    hideDescribeOption("about-us-describe", "about-us-header", "about-us-txt" );
    hideDescribeOption("roofs-describe", "roofs-header", "roofs-txt" );
    hideDescribeOption("hydro-describe", "hydro-header", "hydro-txt");

}




function showDescribeOption(describe, header, txt) {

    document.getElementById("roll-menu").setAttribute("style","width:20%");


    document.getElementById(describe).setAttribute("style","display: inline-table");


    document.getElementById("content").setAttribute("style","min-height: 200px");

    document.getElementById(header).setAttribute("style","font-size:20px");
    document.getElementById(txt).setAttribute("style","font-size:20px");

}


function showAboutUs() {
    showDescribeOption("about-us-describe", "about-us-header", "about-us-txt");
    hideDescribeOption("roofs-describe", "roofs-header", "roofs-txt" );
    hideDescribeOption("hydro-describe", "hydro-header", "hydro-txt");


}


function showRoofs() {
    showDescribeOption("roofs-describe", "roofs-header", "roofs-txt");
    hideDescribeOption("about-us-describe", "about-us-header", "about-us-txt" );
    hideDescribeOption("hydro-describe", "hydro-header", "hydro-txt");

}

function showHydro() {
    showDescribeOption("hydro-describe", "hydro-header", "hydro-txt");
    hideDescribeOption("about-us-describe", "about-us-header", "about-us-txt" );
    hideDescribeOption("roofs-describe", "roofs-header", "roofs-txt" );



}




function hideDescribeOption(describe, header, txt) {

    document.getElementById("roll-menu").setAttribute("style","width:0%");


    document.getElementById(describe).setAttribute("style","display: none");


    document.getElementById("content").setAttribute("style","min-height: 0px");

    document.getElementById(header).setAttribute("style","font-size:0px");
    document.getElementById(txt).setAttribute("style","font-size:0px");


}
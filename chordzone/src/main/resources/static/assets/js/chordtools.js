function chordGenerator() {
    var gam = document.getElementById("gamSelect");
    var gam2nd = document.getElementById("2ndGamSelect");
    var gamere = gam.options[gam.selectedIndex].text +
        gam2nd.options[gam2nd.selectedIndex].text;
    console.log("Gamere = " + gamere);
    // var deviceList = [[${messages}]];
    // for(var i = 0; i < deviceList.length; i++){
    //     if(document.getElementById("gamSelect").value == "empty") {
    //         document.getElementById("currentVersion").value = "Please select a device."
    //         break;
    //     }
    //     if(document.getElementById("gamSelect").value == "livingRoom") {
    //         document.getElementById("currentVersion").value = deviceList[0].version;
    //         break;
    //     }
    //     if(document.getElementById("gamSelect").value == "restRoom") {
    //         document.getElementById("currentVersion").value = deviceList[1].version;
    //         break;
    //     }
    //     if(document.getElementById("gamSelect").value == "kitchen") {
    //         document.getElementById("currentVersion").value = deviceList[2].version;
    //         break;
    //     }

}
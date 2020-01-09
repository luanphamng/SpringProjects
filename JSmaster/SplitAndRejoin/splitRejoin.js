window.onload = splitAndRejoin();

function splitAndRejoin(){
    const str = "Hello+Beautiful#World";
    const splited = str.split(/[\+#]/);
    var spliterCharacter = [];
    for(var i = 0; i < str.length; i++){
        if(str[i] == "+" || str[i] == "#"){
            spliterCharacter.push(str[i]);
        }
    }
    var rejoin = "";
    for (i = 0; i <= spliterCharacter.length; i++) {
        if(i< spliterCharacter.length)
            rejoin += splited[i] + spliterCharacter[i];
        else
            rejoin += splited[i];
    }
    console.log(splited);
    console.log(spliterCharacter);
    console.log(rejoin); // Result
}
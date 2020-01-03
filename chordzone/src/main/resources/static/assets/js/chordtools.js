window.onload = chordGenerator();

function chordGenerator() {
    var gam = document.getElementById("gamSelect");
    var gam2nd = document.getElementById("2ndGamSelect");
    var gamere = gam.options[gam.selectedIndex].text +
        gam2nd.options[gam2nd.selectedIndex].text;
    var chordList = chordsToDisplay(gamere);

    var chordToHTML = '';
    var chordToHTML2 = '';
    for(i = 0; i < chordList.length; i++){
        if(i<3){
            chordToHTML += HTMLButton(chordList[i]);
        }
        else{
            chordToHTML2 += HTMLButton(chordList[i]);
        }
    }
    // Generate buttons of chord base on gamere
    document.getElementById('arrayButtonOfChords').innerHTML = chordToHTML;
    document.getElementById('arrayButtonOfChordsContinue').innerHTML = chordToHTML2;
    console.log("Gamere = " + gamere);
    console.log(chordList);
    console.log(chordToHTML);
    // C.....................C,F,G......Am,Dm,Em
    // D.....................D,G,A......Bm,Em,F#m
    // E.....................E,A,B......C#m,F#m,G#m
    // F.....................F,Bb,C.....Dm,Gm,Am
    // G.....................G,C,D......Em,Am,Bm
    // A.....................A,D,E......F#m,Bm,C#m
    // B.....................B,E,F#.....G#m,C#m,D#m
    //
    // Cm....................Cm,Fm,Gm...Eb,Ab,Bb
    // Dm....................Dm,Gm,Am...F,Bb,C
    // Em....................Em,Am,Bm...G,C,D
    // Fm....................Fm,Bbm,Cm..Ab,Db,Eb
    // Gm....................Gm,Cm,Dm...Bb,Eb,F
    // Am....................Am,Dm,Em...C,F,G
    // Bm....................Bm,Em,F#m..D,G,A

}

function chordsToDisplay(g) {
    switch (g) {
        case "CMajor":
            return ["C","F","G","Am","Dm","Em"];
            break;
        case "C#Major":
            return ["C#","F#","G#","A#m","D#m","E#m"];
            break;
        case "DMajor":
            return ["D","G","A","Bm","Em","F#m"];
            break;
        case "D#Major":
            return ["D#","G#","A#","Cm","Fm","Em"];
            break;
        case "EMajor":
            return ["E","A","B","C#m", "F#m" ,"G#m"];
            break;
        case "FMajor":
            return ["F","Bb","C","Dm","Gm","Am"];
            break;
        case "F#Major":
            return ["F#","B","C#","D#m","G#m","A#m"];
            break;
        case "GMajor":
            return ["G","C","D","Em","Am","Bm"];
            break;
        case "G#Major":
            return ["G#","C#","D#","E#m","A#m","Cm"];
            break;
        case "AMajor":
            return ["A","D","E","F#m","Bm","C#m"];
            break;
        case "A#Major":
            return ["A#","D#","F","Em","Cm","Dm"];
            break;
        case "BMajor":
            return ["B","E","F#","G#m","C#m","D#m"];
            break;
            /* Minor gamere */
        case "CMinor":
            return ["Cm","Fm","Gm","Eb","Ab","Bb"];
            break;
        case "C#Minor":
            return ["C#m","F#m","G#m","E","A","B"];
            break;
        case "DMinor":
            return ["Dm","Gm","Am","F","Bb","C"];
            break;
        case "D#Minor":
            return ["D#m","G#m","A#m","F#","B","C#"];
            break;
        case "EMinor":
            return ["Em","Am","Bm","G","C","D"];
            break;
        case "FMinor":
            return ["Fm","Bbm","Cm","Ab","Db","Eb"];
            break;
        case "F#Minor":
            return ["F#m","Bm","C#m","A","D","E"];
            break;
        case "GMinor":
            return ["Gm","Cm","Dm","Bb","Eb","F"];
            break;
        case "G#Minor":
            return ["G#m","C#m","D#m","B","E","F#"];
            break;
        case "AMinor":
            return ["Am","Dm","Em","C","F","G"];
            break;
        case "A#Minor":
            return ["A#m","D#m","Fm","C#","F#","G#"];
            break;
        case "BMinor":
            return ["Bm","Em","F#m","D","G","A"];
            break;
        default:
            break;
    }
}

function HTMLButton(key){
    return '<div class="col"><button value=' + key + ' type="" class="btn btn-primary mb-2" onclick="gamButtonOnClick(this.value)">' + key + '</button></div>';
}

function gamButtonOnClick(value){
    console.log(value);
    var appenText = '[' + value + ']';
    document.getElementById("textBoxChords").value += appenText;
}


/* Forum tracking. Most popular pages */

var mainForumID = "84";   /* default category on main page */
var topTitle = document.title;  /* grabs page titles */
var docUrl = document.location.href; /* grabs current url */


/* URLs for manual tag */
var searchUrl = "http://forums.oracle.com/forums/search!default.jspa";
var guestsettingsUrl = "http://forums.oracle.com/forums/guestsettings!default.jspa";
var searchresultUrl = "http://forums.oracle.com/forums/search.jspa?";
var usersettingsUrl ="http://forums.oracle.com/forums/usersettings!default.jspa";
var multiUrl = "http://forums.oracle.com/forums/post!post.jspa";
var editUrl1 = "http://forums.oracle.com/forums/post!";
var editUrl2 = "http://forums.oracle.com/forums/post.jspa";
var spellUrl = "http://forums.oracle.com/forums/spell.jspa";
var newmessageUrl = "http://forums.oracle.com/forums/thread.jspa";
var loginUrl = "http://forums.oracle.com/forums/login.jspa";
var logoutUrl = "http://forums.oracle.com/forums/logout.jspa";
var watchUrl = "http://forums.oracle.com/forums/editwatches!default.jspa";


/* Set pageName based on query string present */

var categoryID=getQV('categoryID');
if (categoryID) {
    categoryID=unescape(categoryID).toLowerCase().replace(/\++/g," ");
    if (categoryID!=mainForumID) {
        s_pageName= "F: Category: "+categoryID+": "+topTitle;
      
      
   } else {  s_pageName= "F: "+topTitle;

       } 
}

/* Captures forums and new posts */
var forumID=getQV('forumID');
if (forumID) {
    forumID=unescape(forumID).toLowerCase().replace(/\++/g," ");      
      s_pageName= "F: Forum: "+forumID+": "+topTitle;

}

if (docUrl==multiUrl){
    s_pageName= "F: "+topTitle;
          
}

if (docUrl==editUrl1 || docUrl==editUrl2){
    s_pageName= "F: Post Message: Edit";
          
}

if (docUrl==spellUrl){
    s_pageName= "F: "+topTitle;
          
}

var threadID=getQV('threadID');
if (threadID) {
    threadID=unescape(threadID).toLowerCase().replace(/\++/g," ");      
      s_pageName= "F: Thread: "+threadID+": "+topTitle;

}

var userID=getQV('userID');
if (userID) {
    userID=unescape(userID).toLowerCase().replace(/\++/g," ");      
      s_pageName= "F: Profile: "+userID+": "+topTitle;

}

var annID=getQV('annID');
if (annID) {
    annID=unescape(annID).toLowerCase().replace(/\++/g," ");      
      s_pageName= "F: Annoucement: "+annID+": "+topTitle;
 
}

var msgID=getQV('msgID');
if (msgID) {
    msgID=unescape(msgID).toLowerCase().replace(/\++/g," ");      
      s_pageName= "F: "+msgID+": "+topTitle;
 
}


/* Reply to thread post & new thread creation */
var messageID=getQV('messageID');
if (messageID) {
    mmessageID=unescape(messageID).toLowerCase().replace(/\++/g," ");      
/*    var messageUrl = document.location.href.replace(/\?.+$/,""); */
       
/* tmID gets hidden value to match messageID with threadID */
/* Replying to thread and message give same result         */
  
    if (topTitle =="Post Message: Reply") { 
        
        var tmID = document.postform.threadID.value;
      	s_pageName= "F: Message: "+tmID+": "+messageID+": "+topTitle; 
      
      	
      } else {
      	s_pageName= "F: Message: "+messageID+": "+topTitle; 
     
      	}
}

/* Search tagging for main page, search with cat or forum and results */

var objID=getQV('objID'); 
if (objID) {
    objID=unescape(objID).toLowerCase().replace(/\++/g," "); 
    var q=getQV('q'); 
    
      if (q) {
       q=unescape(q).toLowerCase().replace(/\++/g," ");      
       s_pageName= "F: "+topTitle+": "+objID+": "+q;
     
      } else {
      	      	     
       s_pageName= "F: "+topTitle+": "+objID;
      
      }
            
    } else if (!objID) {
    	
    	if (docUrl==searchUrl){        
              s_pageName= "F: "+topTitle+": Default";
          
    }
}    	


/* Look for pages without query strings and determine pageName */

if (docUrl==guestsettingsUrl){
    s_pageName= "F: Guest: "+topTitle;
          
}

if (docUrl==usersettingsUrl){
    s_pageName= "F: Member: "+topTitle;
          
}

if (docUrl==loginUrl){
    s_pageName= "F: Sign In";
          
}

if (docUrl==logoutUrl){
    s_pageName= "F: Log Out";
          
}

if (topTitle=="Your Watches"){
    s_pageName= "F: Editing Watches";
          
}


/*********************************** Functions ***********************************/

/* Function: getQV(variable) - Given a query string key, returns the corresponding 
   query string value.  Case-insensitive. */
   
function getQV(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if (pair[0].toLowerCase() == variable.toLowerCase()) {
      return pair[1];
    }
  } 
}
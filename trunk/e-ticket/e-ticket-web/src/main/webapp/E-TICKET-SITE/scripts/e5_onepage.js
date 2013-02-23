var oldvalue;
var details_shown;
var billing_details_shown;


function show(payment) {

	if (oldvalue  == "CCA" || oldvalue  == "DBC" || oldvalue  == "DDB" || oldvalue == "GPY" || oldvalue == "DSK" || oldvalue == "IDL") {
		if (oldvalue != "DDB" && oldvalue != "GPY" && oldvalue != "DSK" && oldvalue != "IDL") {
	   		document.getElementById("PAYMENT_TABLE").style.visibility = "hidden";
			document.getElementById("PAYMENT_TABLE").style.display = "none";
			document.getElementById(oldvalue + "2").style.visibility = "hidden";
			document.getElementById(oldvalue + "2").style.display = "none"; 
		}
		document.getElementById(oldvalue).style.visibility = "hidden";	
	   	document.getElementById(oldvalue).style.display = "none";  
	}

	if (payment == "CCA" || payment == "DBC" || payment == "DDB" || payment == "GPY" || payment == "DSK" || payment == "IDL") {
		if (payment != "DDB" && payment != "GPY" && payment != "DSK" && payment != "IDL") {
			document.getElementById("PAYMENT_TABLE").style.visibility = "visible";
			document.getElementById("PAYMENT_TABLE").style.display = "block";
			document.getElementById(payment + "2").style.visibility = "visible";
			document.getElementById(payment + "2").style.display = "block"; 
		}
		document.getElementById(payment).style.visibility = "visible";
		document.getElementById(payment).style.display = "block";
		oldvalue = payment; 
	}
}




function showlayer(layerid) {
	document.getElementById("OPC").style.visibility = "visible";
	document.getElementById("OPC").style.display = "block"; 
}






function copyGPYvalues() {
	var ptype = document.getElementsByName('PAYMENTTYPE_ID')[0].value;
	
	if (ptype == 'GPY') {
		document.getElementsByName('LSV_HOLDER')[0].value = document.getElementsByName('GPY_HOLDER')[0].value;
	    document.getElementsByName('LSV_BLZ')[0].value = document.getElementsByName('GPY_BLZ')[0].value;
    	document.getElementsByName('LSV_ACCOUNT_NO')[0].value = document.getElementsByName('GPY_ACCOUNT_NO')[0].value; 
	}
	else if (ptype == 'IDL') {
		document.getElementsByName('LSV_BANK_NAME')[0].value = document.getElementsByName('IDL_BANK_NAME')[0].value; 
	}
	else if (ptype == 'DSK') {
		document.getElementsByName('LSV_BANK_NAME')[0].value = document.getElementsByName('DSK_BANK_NAME')[0].value; 
	}
}





function checkIsoCode() {

var ns4 = document.layers;
var ie4 = document.all;
var ns6 = document.getElementById && !document.all;
var op7 = window.opera && (window.getComputedStyle || document.createRange || document.compatMode);
crossobj = ns6? document.getElementById("zip_asterix") : document.all.zip_asterix;
var country

	if (document.personal) {
		try { country = document.personal.D_COUNTRY_ID.value; }
		catch(e){}
	} 
	
	else { country = 0; }
	if (document.personal.B_COUNTRY_ID) {
		b_country = document.personal.B_COUNTRY_ID.value; }
	else { b_country = 0; }

	var obj;
	var displaystyle;

	if (ns4 || ns6 || op7) {
    	displaystyle = "table-row"; }
	else {
		displaystyle = "block";
  }

  if(country != "") {
		for(i=0; i<=countries_no_zip.length; i++) {
			if(countries_no_zip[i] == country) {
				obj = country; }
		}
		var show = false;
		for(i=0; i<countries_vat.length; i++){
		if(countries_vat[i] == country) {
	        show = true;}
		}

    if (country == 400 || country == 404 || country == 720 || country == 732) {
		try{
        dstate = document.personal.D_STATE_ID.value;
        removeSelectboxStateEntries();
        setSelectboxStateEntries();
        selectbox_set('D_STATE_ID', dstate);
        document.getElementById("D_STATE").style.visibility="visible";
        document.getElementById("D_STATE").style.display=displaystyle;
		}
	catch(e){}
    } else {
	try{
      document.getElementById("D_STATE").style.visibility="hidden";
      document.getElementById("D_STATE").style.display="none";
      document.getElementsByName('D_STATE_ID')[0].value='';
	  }
	catch(e){}
      }

    if (document.getElementById("BIL").style.display == "block") {
	try{
      if (b_country == 400 || b_country == 404 || b_country == 720 || b_country == 732) {
        bstate = document.personal.B_STATE_ID.value;
        removeSelectboxStateEntriesBIL();
        setSelectboxStateEntriesBIL();
        selectbox_set('B_STATE_ID', bstate);
        document.getElementById("B_STATE").style.visibility="visible";
        document.getElementById("B_STATE").style.display=displaystyle; }
      else {
        document.getElementById("B_STATE").style.visibility="hidden";
        document.getElementById("B_STATE").style.display="none";
        document.getElementsByName('B_STATE_ID')[0].value='';
        }
	}
	catch(e){}
    }

	/**/
	
	try{
		if (crossobj.style) {
			if(obj == country ) {
				if (ie4||ns6) {
					crossobj.style.visibility = "hidden"; 
				}
				else if (ns4) {
					document.zip_asterix.visibility = "hide"; 
				}
			}
			else {
				if (ie4||ns6) {
					crossobj.style.visibility = "visible"; 
				}
				else if (ns4) {
					document.zip_asterix.visibility = "visible"; 
				}
			}
		}
		}
		catch(e){}

		if (show == true) {
			if (document.getElementById("VAT")) {
				document.getElementById("VAT").style.visibility="visible";
				document.getElementById("VAT").style.display=displaystyle; }
			if (document.getElementById("VAT2")) {
				document.getElementById("VAT2").style.visibility="visible";
		        document.getElementById("VAT2").style.display=displaystyle;	}
		}
		else {
			if (document.getElementById("VAT")) {
				document.getElementById("VAT").style.visibility="hidden";
		    document.getElementById("VAT").style.display="none";
      }
			if (document.getElementById("VAT2")) {
				document.getElementById("VAT2").style.visibility="hidden";
				document.getElementById("VAT2").style.display="none";
      }
		}
	}

    for(i=0;i<country_no_rev.length;i++) {

    	if (country == country_no_rev[i]) {
        	document.getElementById("SUB").style.visibility="visible";
			document.getElementById("SUB").style.display="block"; }
    }
}



function showbilling(id) {

	if (document.getElementById(id).style.display == "block") {
	    billing_details_shown = false;
    	document.getElementById(id).style.display = "none";
	    document.getElementById("billing").firstChild.nodeValue = showbilling_display; }
	else {
	    billing_details_shown = true;
    	document.getElementById(id).style.display = "block";
	    document.getElementById("billing").firstChild.nodeValue = showbilling_hide; }
	checkIsoCode();
}

function showholder (id) {

	if (details_shown) {
	    details_shown = false;
	    document.getElementById(id).style.display = "none";
    	document.getElementById("cardholder_detail").firstChild.nodeValue = showholder_display; }
	else {
	    details_shown = true;
    	document.getElementById(id).style.display = "block";
	    document.getElementById("cardholder_detail").firstChild.nodeValue = showholder_hide; }
	checkIsoCode();
}


function check () {
try{
	if ((document.personal.CC_HOLDER_FIRSTNAME.value.length + document.personal.CC_HOLDER_LASTNAME.value.length) > 0) {
    	document.getElementById('OPC').style.display = "block"; }
		} catch(e){}

}

function removeSelectboxStateEntries() {
	for(var i=document.personal.D_STATE_ID.length;i>=0;i--) {
	document.personal.D_STATE_ID.options[i] = null;
	}
}

function removeSelectboxStateEntriesBIL() {
	for(var i=document.personal.B_STATE_ID.length;i>=0;i--) {
	document.personal.B_STATE_ID.options[i] = null;
	}
}


function setSelectboxStateEntries() {
	var province_code;

	if(document.personal.D_COUNTRY_ID.value == 400){
		province_code =  province_400;
	}
	if(document.personal.D_COUNTRY_ID.value == 404){
		province_code =  province_404;
	}
	if(document.personal.D_COUNTRY_ID.value == 720){
		province_code =  province_720;
	}
	if(document.personal.D_COUNTRY_ID.value == 732){
		province_code =  province_732;
	}

	for (var id in province_code) {
    if (typeof province_code[id] == 'string') {
  	  var newEntry = new Option(province_code[id],id);
	    document.personal.D_STATE_ID.options[document.personal.D_STATE_ID.length] = newEntry;
    }
	}
}


function setSelectboxStateEntriesBIL() {
	var province_code;
	if(document.personal.B_COUNTRY_ID.value == 400){
		province_code =  province_400;
	}
	if(document.personal.B_COUNTRY_ID.value == 404){
		province_code =  province_404;
	}
	if(document.personal.B_COUNTRY_ID.value == 720){
		province_code =  province_720;
	}
	if(document.personal.B_COUNTRY_ID.value == 732){
		province_code =  province_732;
	}

	for (var id in province_code) {
    if (typeof province_code[id] == 'string') {
		  var newEntry = new Option(province_code[id],id);
		  document.personal.B_STATE_ID.options[document.personal.B_STATE_ID.length] = newEntry;
    }
	}
}


function selectbox_set(selectbox_name, selectbox_value) {
try{
	   box = document.getElementsByName(selectbox_name)[0];
	
	   for (i=0;i<box.length;i++) {
	     if(box.options[i].value == selectbox_value) {
	        box.selectedIndex = i; 
	        break;
	     }   
	   }
   }  
  catch(e){}
}
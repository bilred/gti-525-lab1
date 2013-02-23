/* Last modified aboyer 2012-09-06 -- Modified optrial definition.

http://drh.img.digitalriver.com/DRHM/Storefront/Site/shareit/cm/multimedia/ot/shareit-drso-global-stag.js		
http://a248.e.akamai.net/f/248/5462/2h/store.digitalriver.com/DRHM/Storefront/Site/shareit/cm/multimedia/ot/shareit-drso-global-stag.js
https://drh.img.digitalriver.com/DRHM/Storefront/Site/shareit/cm/multimedia/ot/shareit-drso-global-stag.js		
https://a248.e.akamai.net/f/248/5462/2h/store.digitalriver.com/DRHM/Storefront/Site/shareit/cm/multimedia/ot/shareit-drso-global-stag.js

*/

/**
 * @projectDescription This is a compilation of various common utility functions pertaining to DR site opt and the optimization tool.
 * Uncompressed: http://digitalriver.com/drso/drso-2.0.2.js
 * Minified: http://digitalriver.com/drso/drso-2.0.2.min.js
 * @author Aaron Boyer aboyer@digitalriver.com
 * @version 2.0.2
 */
var DRSO={version:'2.0.2',url:location.href.toLowerCase(),setCookie:function(n,v,a){var b=new Date();a=typeof a==='undefined'?{}:a;a.d=typeof a.d==='undefined'?this.getDomain():a.d;a.e=typeof a.e==='undefined'?null:a.e;a.p=typeof a.p==='undefined'?'/':a.p;b.setTime(b.getTime()+a.e*24*60*60*1000);document.cookie=n+'='+escape(v)+((a.e===null)?'':('; expires='+b.toGMTString()))+'; path='+a.p+((a.d===null)?'':(';domain='+a.d))},getDomain:function(a){a=!a?this.url:a.toString().toLowerCase();return a.match(/\.?[\w]+\.(net|org|com?\.?[a-zA-Z]{0,2})/g)},getCookie:function(a){if(document.cookie.length>0){var b=document.cookie.indexOf(a+'='),c_end;if(b!==-1){b=b+a.length+1;c_end=document.cookie.indexOf(';',b);if(c_end===-1){c_end=document.cookie.length}return unescape(document.cookie.substring(b,c_end))}}return''},deleteCookie:function(a){this.setCookie(a,'',{e:-1})},getRefUrl:function(a){if(!this.getCookie('op_refUrl')){a=typeof a==='undefined'?null:a;var b=document.referrer?document.referrer.toLowerCase():'none';this.setCookie('op_refUrl',b,{e:a})}return this.getCookie('op_refUrl')},clickthruRedirect:function(a,b,c,d){var e='',hrefPrefix='',loc=location.href;d=(typeof d==='undefined')?'':d;loc=loc.substring(0,loc.lastIndexOf('/'));if(a.indexOf('//')===0){hrefPrefix=location.protocol}else if(a.indexOf('/')===0){hrefPrefix=location.protocol+'//'+location.hostname}else if(a.substring(0,4)!=='http'&&a.substring(0,5)!=='https'){while(/^\.\./.test(a)){loc=loc.substring(0,loc.lastIndexOf('/'));a=a.substring(3)}a=loc+'/'+a}if(a.indexOf('?')!==-1){e='&'+a.split('?')[1];a=escape(a.split('?')[0])}window.location=b+'?'+c+'='+hrefPrefix+a+e+d},setSessionVar:function(k,v){var w=window.name;v=escape(v);if(w.indexOf(k)!==-1){w=w.replace(w.split(k+'=')[1].split('&')[0],v)}else if(w.length){w=w+'&'+k+'='+v}else{w=k+'='+v}window.name=w},getSessionVar:function(k){var w=window.name;if(w.indexOf(k)!==-1){return unescape(w.split(k+'=')[1].split('&')[0])}else{return''}},log:function(s){if(typeof console==='object'){console.log(s)}},getParam:function(a){var b=null,delimiters=['&','='],haystack=null,result={},hs_split=null,hs_max=0,i=0,getResult;a=typeof a==='undefined'?false:a;b=a.name||b;delimiters=a.delimiters||delimiters;haystack=a.haystack||haystack;if(!haystack&&!a.delimiters){haystack=location.search.substring(1)}else if(!haystack&&a.delimiters){haystack=location.pathname}else if(haystack&&!a.delimiters){haystack=haystack.substring(haystack.indexOf('?')+1)}else if(haystack&&a.delimiters){if(haystack.indexOf('?')!==-1){haystack=haystack.substring(0,haystack.indexOf('?'))}}hs_split=haystack?haystack.split(delimiters[0]):hs_split;hs_max=hs_split?hs_split.length:hs_max;if(!hs_split){return false}for(i;i<hs_max;i+=1){if(hs_split[i].split(delimiters[1])[1]){result[hs_split[i].split(delimiters[1])[0]]=hs_split[i].split(delimiters[1])[1]}}if(b){return result[b]}return result},getSerializedParam:function(a,b,c,d,e){var f=a||undefined,delim_start=b||undefined,delim_end=c||undefined,haystack=d||undefined;return this.getParam({'name':f,delimiters:[delim_start,delim_end],haystack:haystack})},getURLparam:function(a){return this.getParam({'name':a})},getUrlParam:function(a){return this.getParam({'name':a})},disableOT:function(){if(typeof ptomodule==='object'&&(this.getParam({name:'optest'})==='false'||this.getCookie('optest')==='false')){ptomodule.Enabled=false}},isNewVisitor:function(a){a=typeof a==='undefined'?90:a;if(this.getCookie('op_seenStore')==='true'){if(!this.getCookie('op_newVisitor')){this.setCookie('op_newVisitor','false')}}else{this.setCookie('op_seenStore','true',{e:a});this.setCookie('op_newVisitor','true')}return this.getCookie('op_newVisitor')==='true'?true:false},loadBinaryCounter:function(a,b){var c=new Image(),d=new Date(),i,qs='';window.drso_temp_images=[];a.path=typeof a.path==='undefined'?null:a.path;a.liid=typeof a.liid==='undefined'?null:a.liid;a.href=typeof a.href==='undefined'?null:a.href;a.qs=typeof a.qs==='undefined'?null:a.qs;a.sid=typeof a.sid==='undefined'?'{{$creative.sessionId}}':a.sid;a.sid=/creative\.sessionId/.test(a.sid)?this.getCookie(a.liid):a.sid;if(!a.path||!a.sid||!a.liid){if(a.href){window.location=a.href}else{return false}}else if(a.qs){for(i in a.qs){qs+='&'+i+'='+a.qs[i]}}c.onload=function(){if(typeof b==='function'){b()}else if(a.href){window.location=a.href}};c.src=a.path+'?'+a.liid+'='+a.sid+qs+'&ts='+d.getTime();window.drso_temp_images.push(c)},init:function(){this.disableOT()}};
var ptomodule={A:{},C:{},D:document,L:document.location,M:[],Q:{},T:new Date(),U:'',V:'2.7',Enabled:true,ST:"script",SA:
{"type":"text/javascript"},I:function(){var s=this.L.search;var c=this.D.cookie;if(s.length>3){for(var a=s.substring(1)
.split("&"),i=0,l=a.length;i<l;i++){var p=a[i].indexOf("=");if(p>0)this.Q[a[i].substring(0,p)]=unescape(a[i].substring(
p+1));}}if(c.length>3){for(var a=c.split(";"),i=0,b=a.length;i<b;i++){var v=a[i].split("=");while(v[0].substring(0,
1)==" ")v[0]=v[0].substring(1,v[0].length);if(v.length==2)this.C[v[0]]=unescape(v[1]);}}},B:function(){var n;this.A={
};var _o=this;this.A.D_ts=Math.round(_o.T.getTime()/1000);this.A.D_tzo=_o.T.getTimezoneOffset();this.A.D_loc=_o.L.protocol+
"//"+_o.L.hostname+_o.L.pathname;this.A.D_ckl=_o.D.cookie.length;this.A.D_ref=_o.D.referrer;if(typeof optrial=="object")
for(n in optrial)this.A[n]=optrial[n];for(n in this.Q)this.A[n]=this.Q[n];for(n in this.C)if(n.substring(0,2)=="op")this.A[n]=
this.C[n];},S:function(){var q='';for(var n in this.A)if(this.A[n]!=null && this.A[n]!="")q+=(q.length>0?"&":(this.U.indexOf(
"?")>0?"&":"?"))+n+"="+escape(this.A[n]);return this.U+q;},SC:function(n,v,e,d){var de=new Date();de.setTime(
de.getTime()+e * 1000);this.D.cookie=n+"="+escape(v)+((e==null)?"":("; expires="+de.toGMTString()))+"; path=/"+((d==
null)?"":(";domain="+d));},SLD:function(){var sld=this.D.domain;var dp=sld.split(".");var l=dp.length;if(l<2)sld=null;
else if(!isNaN(dp[l-1])&&!isNaN(dp[l-2]))sld=null;else sld="."+dp[l-2]+"."+dp[l-1];return sld;},R:function(r,c,d,
e){if(this.Enabled){var b=true;if(r<1000){b=(Math.floor(Math.random()*1000)<r);if(c!=null){if(this.C[c]!=null)b=(this.C[c]!=
"mvt-no");else this.SC(c,b?"mvt-yes":"mvt-no",e,d);}}if(b){var t='<'+this.ST+' src="'+this.S()+'"';for(n in this.SA)
t+=(" "+n+'="'+this.SA[n]+'"');t+='><\/'+this.ST+'>';this.D.write(t);}}},addModule:function(s,f){this.M[s]=f;
},displayModule:function(s){if(typeof this.M[s]=="function")this.M[s]();},hasModules:function(){return count(this.M)>0;
}};ptomodule.I();
var optrial = optrial || {};
var opcounter = opcounter || {};

DRSO.init();
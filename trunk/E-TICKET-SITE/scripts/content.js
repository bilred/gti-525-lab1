function opCreativeSetCookieA(n, v, d, e){var de = new Date;de.setTime(de.getTime() + e * 1000);document.cookie = n + "=" + escape(v) + ((e==null) ? "" : ("; expires=" + de.toGMTString())) + "; path=/" + ((d==null) ? "" : (";domain=" + d));}
function opCreativeGetDocumentSLD(){var sld = document.domain;var dp = sld.split(".");var l = dp.length;if (l < 2) sld = null;else if (!isNaN(dp[l-1]) && !isNaN(dp[l-2])) sld = null;else sld = "." + dp[l-2] + "." + dp[l-1];return sld;}
opCreativeSetCookieA("op393mycommerceidgum", "a04p07z0ah2923y0835tk52dd", opCreativeGetDocumentSLD(), 2592000);
opCreativeSetCookieA("op393mycommerceidliid", "a04p07z0ah2923y0835tk52dd", opCreativeGetDocumentSLD(), 86400);

document.write('<style type="text/css">' +
'.opDefaultContent_mycommerceid' +
'{display:none;}</style>');


function isEqual(pass1, pass2, check, btn) {
	pass1Val = document.getElementById(pass1).value;
	pass2Val = document.getElementById(pass2).value;
	checkSpan = document.getElementById(check);
	subm = document.getElementById(btn);
	if (pass1Val.length < 3) {
		checkSpan.innerHTML = "* Password must be<br/> at least 3 characters.";
		subm.disabled = true;
		subm.style.color = "#bbb";
	} else {
		if (pass1Val == pass2Val) {
			checkSpan.innerHTML = "";
			subm.disabled = false;
			subm.style.color = "#18b13a";
		} else {
			checkSpan.innerHTML = "* Password does<br/> not matches.";
			subm.disabled = true;
			subm.style.color = "#bbb";
    	}
    }	
}
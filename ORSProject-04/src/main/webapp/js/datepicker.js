$(document).ready(function() {
	$("#udate").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : '1980:2007',
		minDate : new Date(1980, 0, 1),
		maxDate : new Date(2007, 11, 31)
	});
});
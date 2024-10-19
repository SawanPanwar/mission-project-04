$(function() {
	$("#udate").datepicker({
		dateFormat : 'dd-mm-yy', // Set the date format to dd-MM-yyyy
		changeMonth : true,
		changeYear : true,
		yearRange : '1980:2006', // Set the year range between 1980 and 2002
		minDate : new Date(1980, 0, 1), // Minimum date (January 1, 1980)
		maxDate : new Date(2006, 11, 31) // Maximum date (December 31, 2002)
	});
});
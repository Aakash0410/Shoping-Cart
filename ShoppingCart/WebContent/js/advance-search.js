jQuery(document).ready(function($){"use strict";$(function(){var initSlider=slider.init;if(initSlider){$('select#experience_min, select#experience_max').selectToUISlider({labels:10,labelSrc:'text',tooltip:true,});$('select#sallary_min, select#sallary_max').selectToUISlider({labels:11,labelSrc:'text',tooltip:true,});}});});
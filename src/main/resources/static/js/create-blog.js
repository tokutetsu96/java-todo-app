'use strict';

$(document).ready(function() {
	const md = window.markdownit();

	// Markdownプレビューを更新
	$('#content').on('input', function() {
		const markdownText = $(this).val();
		const htmlContent = md.render(markdownText);
		$('#markdownPreview').html(htmlContent);
	});
});
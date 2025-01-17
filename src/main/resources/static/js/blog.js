'use strict';

$(document).ready(function() {
	// 画像プレビューを表示する関数
	$('#image').on('change', function(event) {
		const input = event.target;
		const preview = $('#imagePreview');

		if (input.files && input.files[0]) {
			const reader = new FileReader();

			reader.onload = function(e) {
				preview.attr('src', e.target.result);
				preview.show(); // プレビューを表示
			};

			reader.readAsDataURL(input.files[0]);
		}
	});


	$("#search-button").click(function() {
		const query = $("#search-input").val();
		if (!query) {
			return;
		}
		const apiUrl = `/api/blog/search?query=${query}`;

		// REST API呼び出し
		$.ajax({
			url: apiUrl,
			type: "GET",
			dataType: "json",
			success: function(data) {
				const blogCardContainer = $("#blog-card").parent();
				blogCardContainer.empty();

				data.forEach(blog => {
					const blogCard = `
						<div class="col" id="blog-card">
							<a href="/blog/${blog.id}" class="text-decoration-none text-dark">
								<div class="card h-100 shadow">
									<img src="${blog.imagePath}" class="card-img-top" alt="Blog Image">
									<div class="card-body">
										<h3 class="card-title">${blog.title}</h3>
										<p class="card-text text-muted">Created At: ${blog.createdAt}</p>
										<p class="card-text">Author: ${blog.author}</p>
									</div>
								</div>
							</a>
 						</div>
				`;
					blogCardContainer.append(blogCard);
				});
			},
			error: function(_, status, error) {
				console.error("通信エラー:", status, error);
				alert("データの取得中にエラーが発生しました。");
			}
		});
	});

    $(document).ready(function () {
        var message = /*[[${message}]]*/ ''; // Thymeleafでmessageを埋め込む
        if (message.trim().length > 0) {
            $('#modalMessage').text(message);
            $('#messageModal').fadeIn();
        }

        $('#closeModal').on('click', function () {
            $('#messageModal').fadeOut();
        });
    });
});

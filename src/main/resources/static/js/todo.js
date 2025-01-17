'use strict';

$(document).ready(function() {

	$("#search-button").click(function() {
		const query = $("#search-input").val();
		const apiUrl = `/api/todo/search?query=${query}`;

		$.ajax({
			url: apiUrl,
			type: "GET",
			dataType: "json",
			success: function(data) {
				const tbody = $("tbody");
				tbody.empty();

				data.forEach(todo => {
					tbody.append(`
						<tr>
							<td>${todo.id}</td>
							<td>${todo.title}</td>
							<td>${todo.isCompleted != null ? (todo.isCompleted ? '完了' : '未完了') : '未選択'}</td>
							<td>${todo.createdAt}</td>
							<td>${todo.updatedAt != null ? todo.updatedAt : ' '}</td>
							<td>
								<a class="btn btn-primary btn-sm px-4 py-2" href="/todo/edit/${todo.id}">
									EDIT
								</a>
							</td>
							<td>
								<form action="/todo/delete/${todo.id}" method="post">
									<button class="btn btn-danger btn-sm px-4 py-2" type="submit">
										DELETE
									</button>
								</form>
							</td>
						</tr>
					`);
				});
			},
			error: function(_, status, error) {
				console.error("通信エラー:", status, error);
				alert("データの取得中にエラーが発生しました。");
			}
		});
	});
	
	/**
	 * TodoComplete Confirm関数
	 */
	$(document).ready(function () {
		$(".complete-form").on("submit", function (event) {
			event.preventDefault();
			const confirmation = confirm("このタスクを「完了」にしてもよろしいですか？");
			if (confirmation) {
				this.submit();
			}
		});
	});
});

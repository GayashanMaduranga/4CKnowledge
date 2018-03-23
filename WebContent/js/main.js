$(document).ready(function(){
	
	var add = $("#add");
	var myList = $("#myProductList");
	var list = $("#productList");
	var info = $("#productInfo");
	var qtyField = $("#qtySpinner");
	var order = $("#order");
	var holder = $("#myProductsHolder");
	
	var total = 0;
	
	var product_code, product_name, weight, manufacturer, rel_date, noofPieces, unit_price, qty;
	
	var itemNo = 0;
	
	
	
	order.prop("disabled", true);
	
	if(list.val() == "default"){
		add.prop("disabled", true);
	}
	
	
	$("#clear").click(function(){
		location.reload();
	});
	
	order.click(function(){
		
		var myListItems = holder.children();
		var length = myListItems.length;
		var dataList = {};
		
		for(var i=0; i<length; i++){
			dataList[i] = {};
			dataList[i]["productCode"] = myListItems.eq(i).children().eq(1).data("productCode");
			dataList[i]["quantity"] = myListItems.eq(i).children().eq(2).data("productQty");
		}
		
		//console.log(dataList);
		
		var data = {
			"action":"placeOrder",
			"data":dataList
		};
		
		
        $.post("index.php", data, function(result){
			
        }, 'json');
		
		$("#content").empty();
		var statusMsg = $(".alert-success-order");
		statusMsg.fadeIn();
		
		//location.reload();
		
	});
	
	add.click(function(){
		
		itemNo++;
		$("option[value="+product_code+"]").hide();
		list.val("default");
		//holder.append("<li data-product-code='"+product_code+"' data-product-qty='"+qtyField.val()+"'>Item: "+ itemNo+" - "+ product_code+"/"+ product_name +" QTY: "+qtyField.val()+" <button id='"+product_code+"' type='button' value='remove'>Remove</button></li>");
		
		
		holder.append("<tr>"+
			"<td>"+itemNo+"</td>"+
			"<td data-product-code='"+product_code+"'>"+ product_code+"/"+ product_name +"</td>"+
			"<td data-product-qty='"+qtyField.val()+"'>"+qtyField.val()+"</td>"+
			"<td data-product-price='"+unit_price+"'>"+unit_price+"</td>"+
			"<td><button type='button' class='product-remove btn btn-danger'>Remove</button></td>"+
		"</tr>");
		
		total +=  parseFloat(unit_price)*parseFloat(qtyField.val());
		
		$("#total").text(total.toFixed(2));
		
		add.prop("disabled", true);
		qtyField.prop("disabled", true);
		info.hide();
		
		order.prop("disabled", false);
		
		var statusMsg = $("#alert-success"); 
		statusMsg.fadeIn(500);
		setTimeout(function(){ statusMsg.fadeOut(100) }, 3000);
		
		initTable();
		qtyField.val("");
		
		
		//console.log(myList.children("li").length);
	
	});
	
	$("#myProductsHolder").on("click",".product-remove", function(){
		
		
		var row = $(this).parent().parent();
		
		var code = row.children().eq(1).data("productCode");
		
		var unit = row.children().eq(3).text();
		var q = row.children().eq(2).text();
		
		total -= parseFloat(unit)*parseFloat(q);
		$("#total").text(total.toFixed(2));
		
		$("option[value="+code+"]").show();
		row.remove();
		list.val("default");
		
		
	});
	
	list.change(function(){
		//info.html("<li>23jkd</li>");
		info.show();
		qtyField.val(1);
        var id = $(this).val();
		if(list.val() == "default"){
			add.prop("disabled", true);
			qtyField.prop("disabled", true);
			initTable();
		} else {
			add.prop("disabled", false);
			qtyField.prop("disabled", false);
		}
		
        $.post("index.php", {product_code: id, action:'getInfo'}, function(result){
			product_code = result['product_code'];
			product_name =  result['product_name'];
			weight =  result['weight'];
			manufacturer = result['manufacturer'];
			rel_date = result['rel_date'];
			noofPieces = result['noofPieces'];
			unit_price = result['unit_price'];
			qty = result['quantity'];
			
			for(index in result){
				$("#"+index).html(result[index]);
			}

			qtyField.attr({"max":qty});
			
        }, 'json');
	});

	
	
});
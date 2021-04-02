 const searchbookeduser = () =>{
	console.log("searching");
	let query=$("#search-input").val();
	console.log(query);
	if(query==''){
		$(".search-result").hide();
	}else{
		console.log("somethimg entering..");
		//sending request to server
		let url=`http://localhost:8080/mobile-docker/search/${query}`;
		fetch(url).then((response) => {
			return response.json();
		}).then((data) => {
			//data...
			console.log(data);
			//targeting show ---
			let text=`<div class='list-group'>`;
			data.forEach((bookeduser) => {
			
				text+=`<a href='#myModal-3'data-toggle='modal'class='btn btn-success'>${bookeduser.fname}
				</a>`
					  $('#myModal-3 #mobilenumber').val(bookeduser.mobilenumber);
		    		 $('#myModal-3 #selectbrands').val(bookeduser.selectbrands);
		    		 $('#myModal-3 #selectmodel').val(bookeduser.selectmodel);
		    		 $('#myModal-3 #descrip').val(bookeduser.descrip);
		    		 $('#myModal-3 #reason').val(bookeduser.reason);
		    		 $('#myModal-3 #zipcode').val(bookeduser.zipcode);
		    		 $('#myModal-3 #cityname').val(bookeduser.cityname);
		    		 $('#myModal-3 #fname').val(bookeduser.fname);
		    		 $('#myModal-3 #dateCreated').val(bookeduser.dateCreated);
		    		 $('#myModal-3 #currentstatus').val(bookeduser.currentstatus);
		    		 $('#myModal-3 #customerIdd').val(bookeduser.customerId);
			});   
			text +=`</div>`;
			$(".search-result").html(text);
			$(".search-result").show();
		});	
	}
}
//search input brand
  const searchbrand = () =>{
	console.log("searching..brand");
	let query=$("#search-brand").val();
	console.log(query);
	if(query==''){
		$(".search-result").hide();
	}else{
		console.log("somethimg entering..");
		//sending request to server
		let url=`http://localhost:8080/mobile-docker/searchbrand/${query}`;
		   
		fetch(url).then((response) => {
			return response.json();
		}).then((data) => {
			//data...
			console.log(data);
			/*data = JSON.parse('data');*/
			//targeting show ---
			let text=`<div class='list-group'>`;
			data.forEach((brandsearch) => {
				text+=`<a href='#BrandModal'data-toggle='modal'class='btn btn-success'>${brandsearch.name}</a>`
					text+=`<input type='hidden' id='search-brand' value='${brandsearch.id}'>`
				$('#BrandModal #responseId').val(brandsearch.id);
	   		    $('#BrandModal #brandname').val(brandsearch.name);
			});   
			text +=`</div>`;
			
			$(".search-result").html(text);
			$(".search-result").show();
		});	
	}
}

//search-series
 const searchseries = () => {
	console.log("series searching..");
	let query=$("#search-series").val();
	console.log(query);
	if(query==''){
		$(".search-result-series").hide();
	}else{
		console.log("something entring..");
		//sending request to server
		let url=`http://localhost:8080/mobile-docker/searchseries/${query}`;
		 fetch(url).then((response) => {
			 return response.json();
		 }).then((data) => {
			//data...
				console.log(data);
				/*data = JSON.parse('data');*/
				//targeting show ---
				let text=`<div class='list-group'>`;
				data.forEach((seriessearch) => {
					text+=`<a href='#BrandSeriesUpdateModal' data-toggle='modal' class='btn btn-success'>${seriessearch.name}</a>`	
					$('#BrandSeriesUpdateModal #seriesresponseId').val(seriessearch.id);
		    		 $('#BrandSeriesUpdateModal #seriesname').val(seriessearch.name);
		    		 $('#BrandSeriesUpdateModal #seriesbrandId').val(seriessearch.brandId);
				});   
				text +=`</div>`;
				
				$(".search-result-series").html(text);
				$(".search-result-series").show();
		 });
	  }
 }
	//search basic table  warehouse-table
	const searchwarehouse = () => {
		console.log("searching..");
		let query=$("#search-warehouse").val();
		console.log(query);
		if(query==''){
			$(".search-result-series").hide();
		}else{
			console.log("something entrying..");
			//send request server
			let url=`http://localhost:8080/mobile-docker/searchwarehouse/${query}`;
			fetch(url).then((response) => {
				return response.json();
			}).then((data) => {
				//data--
				console.log(data);
				let text=`<div class='list-group'>`;
				data.forEach((warehousesearch) => {
					text+=`<a href='#myModal-3' data-toggle='modal' class='btn btn-success'>${warehousesearch.seriesName}</a>`	
					 $('#myModal-3 #brandName').val(warehousesearch.brandName);
		    		 $('#myModal-3 #seriesName').val(warehousesearch.seriesName);
		    		 $('#myModal-3 #touchandlcd').val(warehousesearch.touchandlcd);
		    		 $('#myModal-3 #audiojack').val(warehousesearch.audiojack);
		    		 $('#myModal-3 #microphone').val(warehousesearch.microphone);
		    		 $('#myModal-3 #network').val(warehousesearch.network);
		    		 $('#myModal-3 #softwarediagnosis').val(warehousesearch.softwarediagnosis);
		    		 $('#myModal-3 #deadphonediagnosis').val(warehousesearch.deadphonediagnosis);
		    		 $('#myModal-3 #waterdiagnosis').val(warehousesearch.waterdiagnosis);
		    		 $('#myModal-3 #standbyphone').val(warehousesearch.standbyphone);
		    		 $('#myModal-3 #touchscreenglass').val(warehousesearch.touchscreenglass);
		    		 $('#myModal-3 #battery').val(warehousesearch.battery);
		    		 $('#myModal-3 #chargeport').val(warehousesearch.chargeport);
		    		 $('#myModal-3 #loudspeaker').val(warehousesearch.loudspeaker);
		    		 $('#myModal-3 #earspeaker').val(warehousesearch.earspeaker);
		    		 $('#myModal-3 #warehouseIdd').val(warehousesearch.warehouseId);
		    		 $('#myModal-3 #brandseries').val(warehousesearch.brandseries);
		    		 $('#myModal-3 #brand').val(warehousesearch.brand);
				});   
				text +=`</div>`;
				$(".search-result-series").html(text);
				$(".search-result-series").show();
			});	
		  }
	  }


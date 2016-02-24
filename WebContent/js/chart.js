$(function (){
    $('#container').highcharts({
        chart: {type: 'line'},
        title: {text: 'w折线图'},
        xAxis: {categories: []},
        yAxis: {title: {text: 'cm'}},
        plotOptions: {line: {dataLabels: {enabled: true},enableMouseTracking: false}},
        series: [{name: 'L',data: []}]});
});

function updateChart(myTitle, myYAxis, keyWord){
	var data = eval('('+  JSON.stringify($("#dg").datagrid('getData')) + ')' );
	var date = [];
	var grade = [];
	var stuHeight = [];
	var stuWeight = [];
	var stu100mSpeed = [];
	var stuArmSize = [];
	var stuJump = [];
	var stuResponseTime = [];
	var stuHandSize = [];
	var stuRunBack = [];
	var stuRunBackWithBall = [];
	var stuShootBall = [];
	var stuToughHeight = [];
	var stuHeart = [];
	
	for (var i = 0; i < data.rows.length; i++){
		date.push(data.rows[i].formatDate);
		grade[i] = (data.rows[i].stuGrade);
		stuHeight[i] = (data.rows[i].stuHeight);
		stuWeight[i] = (data.rows[i].stuWeight);
		stu100mSpeed[i] = (data.rows[i].stu100mSpeed);
		stuArmSize[i] = (data.rows[i].stuArmsize);
		stuJump[i]=(data.rows[i].stuJump);
		stuResponseTime[i] = (data.rows[i].stuResponseTime);
		stuHandSize[i] = (data.rows[i].stuHandSize);
		stuRunBack[i] = (data.rows[i].stuRunBack);
		stuRunBack[i] = (data.rows[i].stuRunBackWithBall);
		stuShootBall[i] = (data.rows[i].stuShootBall);
		stuToughHeight[i] = (data.rows[i].stuToughHeight);
		stuHeart[i] = (data.rows[i].stuHeart);
	}
	if(keyWord =="stuGrade"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '评分折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(grade))}]
		    });
		});
	}else if(keyWord =="stuWeight"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '体重变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuWeight))}]
		    });
		});
	}else if(keyWord =="stuHeart"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '心肺功能变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuHeart))}]
		    });
		});
		
	}else if(keyWord =="stuJump"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '连续垂直跳变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuJump))}]
		    });
		});
		
	}else if(keyWord =="stuResponseTime"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '反应度变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuResponseTime))}]
		    });
		});
		
	}else if(keyWord =="stuRunBack"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '全场折返跑变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuRunBack))}]
		    });
		});
		
	}else if(keyWord =="stuRunBackWithBall"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '带球折返跑变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuRunBackWithBall))}]
		    });
		});
		
	}else if(keyWord =="stuShootBall"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '1分钟自投自抢变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuShootBall))}]
		    });
		});
		
	}else if(keyWord =="stuToughHeight"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '摸高变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuToughHeight))}]
		    });
		});
		
	}else if(keyWord =="stu100mSpeed"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '百米速度变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stu100mSpeed))}]
		    });
		});
		
	}else if(keyWord =="stuArmSize"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '臂展变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuArmSize))}]
		    });
		});
		
	}else if(keyWord =="stuHandSize"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '手掌大小变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuHandSize))}]
		    });
		});
		
	}else if(keyWord =="stuHeight"){
		$(function(){
			$('#container').highcharts({
				chart: {type: 'line'},
				title: {text: '身高变化折线图'},
				xAxis: {categories: JSON.parse(JSON.stringify(date))},
				yAxis: {title: {text: myYAxis}},
		        plotOptions: {line:{dataLabels:{enabled:true},enableMouseTracking: false}},
		        series: [{name: myTitle,data: JSON.parse(JSON.stringify(stuHeight))}]
		    });
		});
	}
	
}
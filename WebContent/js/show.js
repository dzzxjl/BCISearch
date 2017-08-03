 var myChart = echarts.init(document.getElementById('main') ,  'infographic'); 
        
        var option = {
        	backgroundColor: 'rgba(255,255,255,0.5)',
        
            tooltip: {
                show: true
            },
            legend: {
                data:['Entity']
            },
            xAxis : [
                {
                    type : 'category',
                    data : ["Protein","DNA","RNA","virus","cell_line","cell_type"]
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"Entity",
                    "type":"bar",
                    "data":[248997, 71358, 7724, 871, 58891, 31698]
                }
            ]
        };

        // Ϊecharts���������� 
        myChart.setOption(option); 
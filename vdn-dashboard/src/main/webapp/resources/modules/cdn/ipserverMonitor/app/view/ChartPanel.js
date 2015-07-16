/**
 * 
 */
Ext.define('ifeng.view.ChartPanel', {
	extend: 'Ext.chart.Chart',
	alias: 'widget.chartPanel',
	style: 'background:#fff',
    animate: true,
    store: 'IPServerStore',
    shadow: true,
    theme: 'Category1',
    legend: {
        position: 'right'
    },
    axes: [{
        type: 'Numeric',
        minimum: 0,
        position: 'left',
        fields: ['create_time', 'live_total', 'requst_total', 'video_total', 'total', 'ip'],
        title: '调度频次统计',
        minorTickSteps: 1,
        grid: {
            odd: {
                opacity: 1,
                fill: '#ddd',
                stroke: '#bbb',
                'stroke-width': 0.5
            }
        }
    }, {
        type: 'Category',
        position: 'bottom',
        fields: ['create_time'],
        title: 'Month of the Year'
    }],
    series: [{
        type: 'line',
        highlight: {
            size: 2,
            radius: 2
        },
        axis: 'left',
        xField: 'create_time',
        yField: 'total',
        markerConfig: {
            type: 'cross',
            size: 1,
            radius: 1,
            'stroke-width': 0
        }
    }]
});
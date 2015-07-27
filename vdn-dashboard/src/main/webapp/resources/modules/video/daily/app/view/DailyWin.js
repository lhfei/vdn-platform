Ext.define('ifeng.view.DailyWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.dailyWin',
    
    itemId: '_dailyWin',
    
    width: 680,
    height: 400,
    minHeight: 250,
    minWidth: 400,
    title: '日统计报表',
    maximizable: true,
    maximized: true,
    
    layout: 'border',
    closeAction: 'hide',
    
    tbar: ['->', '-', {
    	type: 'button',
    	text: '表格展示',
    	iconCls: 'icon-grid',
    	action: 'showAvlbGrid'
    	
    }, '-', j$('.highcharts-button')[0]],
    initComponent: function() {
        var me = this;
        Ext.apply(me, {
        	items: [{
        		region: 'center',
        		contentEl: 'chartContainer',
        		split: true
        	},{
        		xtype: 'dailyGrid',
        		region: 'south',
        		split: true,
        		collapsed: true,
        		collapseMode: 'mini'
        	}]
        });
        me.callParent(arguments);
    }

});
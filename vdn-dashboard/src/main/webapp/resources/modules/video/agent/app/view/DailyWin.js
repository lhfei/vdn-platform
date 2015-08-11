Ext.define('ifeng.view.DailyWin', {
    extend: 'Ext.window.Window',
    alias: 'widget.dailyWin',
    
    itemId: '_dailyWin',
    width: '97%',
    height: 600,
    minHeight: 250,
    minWidth: 400,
    title: '日统计报表',
    maximizable: true,
    maximized: false,
    autoScroll: true,
    bodyPadding: '5 5 5 5',
    closeAction: 'hide',
    layout: 'column',
    
    /*tbar: ['->', '-', {
    	type: 'button',
    	text: '表格展示',
    	iconCls: 'icon-grid',
    	action: 'showAvlbGrid'
    	
    }, '-', j$('.highcharts-button')[0]],*/
    
    initComponent: function() {
        var me = this;
        Ext.apply(me, {
        	
        	items: [{
        		columnWidth: 1,
        		defaults: {
        			xtype: 'fieldset',
        			layout: 'fit',
        			padding: '5 5 5 5',
        			collapsible: true,
        			autoScroll: true,
        			height: 320
        		},
        		
        		items: [{
        			title: '流畅度分时概况',
        			items: [{contentEl: 'fluentChart'}]
        		},{
        			title: 'VDN 请求样本数概况',
        			items: [{contentEl: 'vdnSummaryChart'}]
        		},{
        			title: '播放不完整率概况',
        			items: [{contentEl: 'incompleteChart'}]
        		}]
        	}]
        });
        me.callParent(arguments);
    }

});
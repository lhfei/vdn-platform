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
    autoScroll: false,
    padding: '0 5 5 5',
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
        		xtype: 'form',
        		region: 'center',
        		layout: 'column',
        		header: false,
        		split: true,
        		items: [{
        			xtype: 'fieldset',
        			columnWidth: 1,
                    padding: '0 5 5 5',
                    title: '可用性分时统计',
                    autoHeight: true,
                    collapsible: true,
                    collapsed: false,
                    contentEl: 'avlbChart'
        		},{
        			xtype: 'fieldset',
        			columnWidth: 1,
                    padding: '0 5 5 5',
                    title: '流畅度分时统计',
                    collapsible: true,
                    contentEl: 'fluentChart'
        		}]
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
/**
 * 
 */
Ext.define('ifeng.view.MainPanel', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.mainPanel',
	layout: 'border',
	title: '服务器详细信息',
	
    minWidth: 200,
	collapsible: false,
    defaults: {
    	split: true,
        autoScroll: false,
        bodyPadding: 1
    },
    items: [{
    	xtype: 'searchForm',
    	region: 'north',
    	split: true,
    	collapseMode: 'mini',
    	collapsible: true,
    	collapsed: false
    },{
    	xtype: 'infoPanel',
    	region: 'center',
    	autoHeight: true,
    	height: 150,
    	collapseMode: 'mini',
        collapsible: true
    }]
 
});
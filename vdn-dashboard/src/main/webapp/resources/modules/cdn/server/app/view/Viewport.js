Ext.define('ifeng.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    items:[{
    	xtype: 'searchForm',
    	region: 'north',
    	split: true,
    	collapseMode: 'mini',
    	collapsible: true,
    	collapsed: false
    },{
    	xtype: 'serverGrid',
    	region: 'center',
    	autoScroll: true
    }]
});
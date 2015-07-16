Ext.define('ifeng.view.MergeWin', {
	extend: 'Ext.window.Window',
	alias: 'widget.mergeWin',
	singleton: true,
	requires: [ 
	    'Ext.grid.Panel', 
	    'Ext.grid.column.Number',
	    'Ext.grid.column.Date', 
	    'Ext.grid.column.Boolean', 
	    'Ext.grid.View',
	    'Ext.resizer.Splitter' ],

	autoShow: false,
	floating: true,
	height: 250,
	itemId: 'mywindow',
	minHeight: 400,
	minWidth: 320,
	width: 400,
	fixed: true,
	layout: 'border',
	bodyBorder: false,
	closeAction: 'hide',
	collapsible: true,
	frameHeader: false,
	title: 'IP 校对',
	titleCollapse: false,
	hideShadowOnDeactivate: true,
	maximizable: true,
	maximized: true,
	minimizable: true,
	modal: true,

	initComponent: function() {
		var me = this;

		Ext.applyIf(me, {
			items: [ {
				xtype: 'container',
				collapseMode: 'mini',
				region: 'center',
				layout: {
					type: 'hbox',
					align: 'stretch'
				},
				items: [ {
					xtype: 'gridpanel',
					itemId: 'ifengGrid',
					flex: 1,
					width: 150,
					collapsible: true,
					title: 'IFeng IP Repository',
				    columns: [
                        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
		                {header: 'IP',  dataIndex: 'ip',  flex: 2, align: 'center', hidden: false},
		                {header: '国家/地区', dataIndex: 'country', flex: 1, align: 'center'},
		                {header: '省份', dataIndex: 'region', flex: 1, align: 'center'},
                        {header: '城市', dataIndex: 'city', flex: 2, align: 'center'},
		                {header: '区县', dataIndex: 'county', flex: 1, align: 'center'},
		                {header: '运营商', dataIndex: 'isp', flex: 1, align: 'center'},
		                {header: 'Country', dataIndex: 'country_id', flex: 1, align: 'center', hidden: true},
		                {header: 'Region', dataIndex: 'region_id', flex: 1, align: 'center', hidden: true},
		                {header: 'City', dataIndex: 'city_id', flex: 1, align: 'center', hidden: true},
		                {header: 'County', dataIndex: 'county_id', flex: 1, align: 'center', hidden: true},
		                {header: 'ISP', dataIndex: 'isp_id', flex: 1, align: 'center', hidden: true}
                    ],
				}, {
					xtype: 'splitter',
					width: 5
				}, {
					xtype: 'gridpanel',
					itemId: 'aliGrid',
					flex: 1,
					width: 150,
					collapsible: true,
					title: 'Ali IP Repository',
				    columns: [
                        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
		                {header: 'IP',  dataIndex: 'ip',  flex: 2, align: 'center', hidden: false},
		                {header: '国家/地区', dataIndex: 'country', flex: 1, align: 'center'},
		                {header: '省份', dataIndex: 'region', flex: 1, align: 'center'},
                        {header: '城市', dataIndex: 'city', flex: 2, align: 'center'},
		                {header: '区县', dataIndex: 'county', flex: 1, align: 'center'},
		                {header: '运营商', dataIndex: 'isp', flex: 1, align: 'center'},
		                {header: 'Country', dataIndex: 'country_id', flex: 1, align: 'center', hidden: true},
		                {header: 'Region', dataIndex: 'region_id', flex: 1, align: 'center', hidden: true},
		                {header: 'City', dataIndex: 'city_id', flex: 1, align: 'center', hidden: true},
		                {header: 'County', dataIndex: 'county_id', flex: 1, align: 'center', hidden: true},
		                {header: 'ISP', dataIndex: 'isp_id', flex: 1, align: 'center', hidden: true}
                    ],
				}]
			}, {
				xtype: 'panel',
				collapseMode: 'mini',
				region: 'south',
				height: 150,
				split: true,
				collapsed: true,
				animCollapse: false,
				collapsible: true,
				title: 'Result',
				titleCollapse: false
			}, {
				xtype: 'container',
				collapseMode: 'mini',
				region: 'north',
				layout: {
					type: 'hbox',
					align: 'stretch'
				},
				
				items:[{
					xtype: 'panel',
					split: true,
					header: false,
					flex: 1,
					tbar: [{
						xtype: 'buttongroup',
						columns: 3,
						defaults: {
							frame: true,
							scale: 'small'
						},
						items: [{
							xtype:'splitbutton',
							text: '从IFeng 合并 到 Ali',
							iconCls: 'icon-merge',
							menu: [{text: '从IFeng 合并 到 Ali'}]
						},{
							xtype:'splitbutton',
							text: '从Ali 合并 到IFeng',
							iconCls: 'icon-merge',
							menu: [{text: '从Ali 合并 到IFeng'}]
						},{
							text: '导出为IFeng IP 格式',
							iconCls: 'icon-merge'
						}]
					},{
						xtype: 'fieldset',
						style: {
						    borderColor: 'blue',
						    borderStyle: 'dotted'
						},
						flex: 2,
						items: [{
							xtype: 'progressbar',
							hidden: false,
							value: 0.9
						}]
					}]
				}]
			} ]
		});

		me.callParent(arguments);
	}

});
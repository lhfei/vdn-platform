

Ext.define('ifeng.view.SearchForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchForm',

    requires: [
        'Ext.ux.GridComboBoxList',
        'Ext.ux.GridComboBox',
        'Ext.ux.LiveSearchGridPanel',
        'Ext.form.FieldSet',
        'Ext.form.field.Date'
    ],
    
    catetory: '',

    bodyPadding: 10,
    collapsible: true,
    title: '查询',
    header: false,
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
        	items: [{
        		xtype: 'form',
        		anchor: '100%',
        		header: false,
        		padding: '0 0 1 0',
        		items: [{
                    xtype: 'tabpanel',
                    flex: 1,
                    activeTab: 0,
                    items: [
                        {
                            xtype: 'panel',
                            title: '长视频',
                            items: [{
                            	xtype: 'fieldset',
                            	items: [{
                    	        	xtype: 'radiogroup',
                    	        	id: 'longVideo',
                    	        	width: 400,
                    	        	defaults: {
                    	        		handler: function(){
                    	        			var obj = Ext.getCmp('longVideo').getChecked()[0];
                    	        			me.category = obj.getGroupValue();
                    	        		}
                    	        	},
                    	        	items: [{
            	        	        	xtype: 'radiofield',
            	        	        	boxLabel: '全部视频',
            	        	        	name: 'long',
            	        	        	inputValue: 'LG'
            	        	        },{
            	        	        	xtype: 'radiofield',
            	        	        	boxLabel: '纪录片',
            	        	        	name: 'long',
            	        	        	inputValue: 'LG01'
            	        	        },{
            	        	        	xtype: 'radiofield',
            	        	        	boxLabel: '其它长视频',
            	        	        	name: 'long',
            	        	        	inputValue: 'LG99'
            	        	        }]
                    	        }]
                            }]
                        },
                        {
                            xtype: 'panel',
                            title: '短视频',
                            items: [{
                            	xtype: 'fieldset',
                            	items: [{
                            		xtype: 'radiogroup',
                            		id: 'shortVideo',
                    	        	width: 450,
                    	        	defaults: {
                    	        		handler: function(){
                    	        			var obj = Ext.getCmp('shortVideo').getChecked()[0];
                    	        			me.category = obj.getGroupValue();
                    	        		}
                    	        	},
                            		items: [{
                            			xtype: 'radiofield',
                            			boxLabel: '全部视频',
                            			name: 'short',
                            			inputValue: 'ST'
                            		},{
                            			xtype: 'radiofield',
                            			boxLabel: '牛市',
                            			name: 'short',
                            			inputValue: 'ST01'
                            		},{
                            			xtype: 'radiofield',
                            			boxLabel: '外站播放',
                            			name: 'short',
                            			inputValue: 'ST02'
                            		},{
                            			xtype: 'radiofield',
                            			boxLabel: '其它短视频视频',
                            			name: 'short',
                            			inputValue: 'ST99'
                            		}]
                            	}]
                            }]
                        },
                        {
                            xtype: 'panel',
                            title: '直播视频',
                            items: [{
                            	xtype: 'fieldset',
                            	items: [{
                    	        	xtype: 'radiogroup',
                    	        	id: 'liveVideo',
                    	        	width: 200,
                    	        	defaults: {
                    	        		handler: function(){
                    	        			var obj = Ext.getCmp('liveVideo').getChecked()[0];
                    	        			me.category = obj.getGroupValue();
                    	        		}
                    	        	},
                    	        	items: [{
            	        	        	xtype: 'radiofield',
            	        	        	boxLabel: '全部视频',
            	        	        	name: 'live',
            	        	        	inputValue: 'LV'
            	        	        }]
                    	        }]
                            }]
                        },{
                        	xtype: 'panel',
                        	title: 'VIP 视频',
                        	items: [{
                            	xtype: 'fieldset',
                            	items: [{
                    	        	xtype: 'radiogroup',
                    	        	width: 200,
                    	        	id: 'vipVideo',
                    	        	defaults: {
                    	        		handler: function(){
                    	        			var obj = Ext.getCmp('vipVideo').getChecked()[0];
                    	        			me.category = obj.getGroupValue();
                    	        		}
                    	        	},
                    	        	items: [{
            	        	        	xtype: 'radiofield',
            	        	        	boxLabel: '全部视频',
            	        	        	name: 'vip',
            	        	        	inputValue: 'VIP'
            	        	        }]
                    	        }]
                            }]                      	
                        }
                    ]
                }]
        	},{
        		xtype: 'form',
        		anchor: '100%',
        		autoHeight: true,
        		autoScroll: true,
        		items: [{
        			xtype: 'gridcombobox',
        			id: 'ispCombo',
        			itemId: 'ispCombo',
        			fieldLabel: '运营商',
        			labelWidth: 50,
        	    	multiSelect: true,
        	    	displayField: 'comboLabel',
        	    	valueField: 'comboLabel',
        	    	labelAlign: 'right',
        	    	store: 'AgentStore',
        	    	queryMode: 'remote',
        	    	matchFieldWidth: true,
        	    	pickerAlign: 'bl',
        	    	anchor: '100%',
        	    	width: '100%',
        	    	height: '100%',
        	    	autoScroll: true,
        	    	emptyText: '选择运营商查看其可用性统计情况, 默认情况下自动统计 电信、移动、联通的 可用性情况 ',
        	    	gridCfg: {
        	    		store: 'AgentStore',
        	    		selModel: new Ext.selection.CheckboxModel({
        	    			checkOnly: true
        	    		}),
        	    		frame: true,
        	    		autoScroll: true,
        	    		autoHeight: true,
        	    		height: 500,
        	    		columns: [
        	    		    {header: '全选', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        	    	        {header: '运营商名称', dataIndex: 'comboLabel', flex: 1, align: 'center'}
        	    		]
        	    	},
        		}]
        	},{
            	xtype: 'form',
            	header: false,
            	layout: 'hbox',
            	anchor: '100%',
            	defaults: {
            		labelAlign: 'right',
            		xtype: 'combobox',
            		anchor: '100%',
            		padding: '5 5 5 5 ',
                    typeAhead: true,
                    selectOnFocus: true,
                    forceSelection: true,
                    displayField: 'comboLabel',
                    valueField: 'id',
                    queryMode: 'remote',
                    labelWidth: 75,
                    
            	},
            	items: [
                    {
                        flex: 1,
                        id: '_countryCombo',
                        itemId: 'countryCombo',
                        padding: '5 5 5 0',
                        labelAlign: 'right',
                        fieldLabel: '地域',
                        emptyText: '国家',
                        labelWidth: 50,
                        store: 'CountryStore'
                        
                    },
                    {
                        flex: 1,
                        id: '_regionCombo',
                        itemId: 'regionCombo',
                        emptyText: '省份\直辖市',
                        store: 'RegionStore'
                    },
                    {
                        flex: 1,
                        id: '_cityCombo',
                        itemId: 'cityCombo',
                        emptyText: '城市',
                        store: 'CityStore'
                    },
                    {
                        fieldLabel: '查看天数',
                        id: '_rangeCombo',
                        itemId: 'rangeCombo',
                        emptyText: '默认显示最新数据',
                        flex: 1,
                        displayField: 'name',
                        valueField: 'value',
                        queryMode: 'local',
                        store: 'DataRangeStore',
                        padding: '5 5 5 0'
                    },
                    {
                        xtype: 'button',
                        text: '查看',
                        itemId: 'reDrawBtn',
                        iconCls: 'icon-analytics',
                        action: 'reDraw',
                        width: 90,
                        padding: '10 0 5 0 '
                    }
                ]
            }]
        
        });

        me.callParent(arguments);
    }

});
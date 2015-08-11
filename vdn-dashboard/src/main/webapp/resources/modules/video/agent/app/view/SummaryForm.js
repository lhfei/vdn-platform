

Ext.define('ifeng.view.SummaryForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.summaryForm',

    requires: [
        'Ext.ux.GridComboBoxList',
        'Ext.ux.GridComboBox',
        'Ext.ux.LiveSearchGridPanel',
        'Ext.form.FieldSet',
        'Ext.form.field.Date'
    ],
    
    catetory: '',

    bodyPadding: 5,
    collapsible: true,
    title: '查询',
    header: false,
    
	layout: 'hbox',
	anchor: '100%',
	defaults: {
		xtype: 'fieldset',
		margin: '5 5 5 5'
	},
	
	defaultMargins: {top: 5, right: 5, bottom: 5, left: 5},
    
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
        	items: [{
        		flex: 2,
        		title: '长视频',
        		items: [{
    	        	xtype: 'radiogroup',
    	        	id: 'sum_longVideo',
    	        	items: [{
        	        	xtype: 'radiofield',
        	        	boxLabel: '全部视频',
        	        	name: 'summaryRadio',
        	        	inputValue: 'LG',
        	        	checked: true
        	        },{
        	        	xtype: 'radiofield',
        	        	boxLabel: '纪录片',
        	        	name: 'summaryRadio',
        	        	inputValue: 'LG01'
        	        },{
        	        	xtype: 'radiofield',
        	        	boxLabel: '其它长视频',
        	        	name: 'summaryRadio',
        	        	inputValue: 'LG99'
        	        }]
    	        }]
        		
        	},{
        		flex: 2,
        		title: '短视频',
        		items: [{
            		xtype: 'radiogroup',
            		items: [{
            			xtype: 'radiofield',
            			boxLabel: '全部视频',
            			name: 'summaryRadio',
            			inputValue: 'ST'
            		},{
            			xtype: 'radiofield',
            			boxLabel: '牛市',
            			name: 'summaryRadio',
            			inputValue: 'ST01'
            		},{
            			xtype: 'radiofield',
            			boxLabel: '外站播放',
            			name: 'summaryRadio',
            			inputValue: 'ST02'
            		},{
            			xtype: 'radiofield',
            			boxLabel: '其它短视频视频',
            			name: 'summaryRadio',
            			inputValue: 'ST99'
            		}]
            	}]
        	},{
        		flex: 1,
        		title: '直播视频',
				items: [{
					xtype: 'radiogroup',
					items: [{
						xtype: 'radiofield',
						boxLabel: '全部视频',
						name: 'summaryRadio',
						inputValue: 'LV'
					}]
				}]
        	},{
        		flex: 1,
        		title: 'VIP 视频',
        		items: [{
        			xtype: 'radiogroup',
        			items: [{
        				xtype: 'radiofield',
        				boxLabel: '全部视频',
        				name: 'summaryRadio',
        				inputValue: 'VIP'
        			}]
        		}]
        	},{
        		flex: 1,
        		title: '查看天数',
        		items: [{
        			xtype: 'combobox',
					anchor: '100%',
					name: 'dataRange',
					emptyText: '默认显示最新数据',
					flex: 1,
					displayField: 'name',
					valueField: 'value',
					queryMode: 'local',
					store: 'DataRangeStore',
					typeAhead: true,
					selectOnFocus: true,
					forceSelection: true
        		}]
        	},{
        		xtype: 'button',
        		text: '查询',
        		width: 90,
        		itemId: 'summarySearchBtn',
        		action: 'searchSummary',
                iconCls: 'icon-analytics',
        		padding: '5 5 5 5',
        		margin: '20 5 5 5 '
        	}]
        
        });

        me.callParent(arguments);
    },
    
    getCategory: function() {
    	return this.category;
    }

});
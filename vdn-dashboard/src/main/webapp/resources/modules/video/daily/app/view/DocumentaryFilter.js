Ext.define('ifeng.view.DocumentaryFilter', {
    extend: 'Ext.form.Panel',
    alias: 'widget.documentaryFilter',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    height: 250,
    layout: 'fit',
    bodyPadding: 10,
    title: '纪录片',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldset',
                    padding: '5 0 5 5',
                    autoScroll: true,
                    collapsible: true,
                    autoHeight: true,
                    layout: 'column',
                    title: '',
                    items: [
                        {
                        	columnWidth: 0.6,
                            xtype: 'form',
                            itemId: 'auditTypeForm',
                            padding: '5 5 5 5',
                            header: false,
                            defaults: {
                        		xtype: 'combobox',
                        		labelWidth: 140,
                        		anchor: '100%',
                        		labelAlign: 'right',
                        		selectOnFocus: true,
                                forceSelection: true,
                                typeAhead: true,
                                queryMode: 'local',
                                store: 'AuditTypeStore',
                                displayField: 'name',
                                valueField: 'value'
                        	},                            
                            items: [
                                {fieldLabel: '视频概况', id: 'd_gk'},
                                {fieldLabel: '视频错误详情', id: 'd_cwxq'},
                                {fieldLabel: '视频资源信息', id: 'd_zyxx'},
                                {fieldLabel: '视频区域信息', id: 'd_qyxx'},
                                {fieldLabel: '视频全球平均播放统计', id: 'd_qqtj'},
                                {fieldLabel: 'IP 地域、运营商统计', id: 'd_iptj'}
                            ]
                        },
                        {
                        	columnWidth: 0.4,
                            xtype: 'form',
                            itemId: 'dataRangeForm',
                            padding: '5 5 5 5 ',
                            header: false,
                            defaults: {
                        		anchor: '100%',
                        		selectOnFocus: true,
                                displayField: 'name',
                                forceSelection: true,
                                queryMode: 'local',
                                store: 'DataRangeStore',
                                typeAhead: true,
                                valueField: 'value'
                        	},                            
                            items: [
                                {xtype: 'combobox', id: 'd_gk_rng'},
                                {xtype: 'combobox', id: 'd_cwxq_rng'},
                                {xtype: 'combobox', id: 'd_zyxx_rng'},
                                {xtype: 'combobox', id: 'd_qyxx_rng'},
                                {xtype: 'combobox', id: 'd_qqtj_rng'},
                                {xtype: 'combobox', id: 'd_iptj_rng'}
                            ]
                        },
                        {
                            xtype: 'form',
                            margin: 5,
                            width: 120,
                            header: false,
                            defaults: {
                            	text: '查询报表',
                            	iconCls: 'icon-documentary'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    handler: function(){
                                    	var type = Ext.getCmp('d_gk').getValue()
                                    	var range = Ext.getCmp('d_gk_rng').getValue()
                                    	alert(type +'><'+ range)
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margin: '5 0 0 0',
                                    handler: function(){
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margin: '5 0 0 0',
                                    handler: function(){
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margin: '5 0 0 0',
                                    handler: function(){
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margin: '5 0 0 0',
                                    handler: function(){
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    margin: '5 0 0 0',
                                    handler: function(){
                                    	ifeng.app.getController('DailyController').doCheck();
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});
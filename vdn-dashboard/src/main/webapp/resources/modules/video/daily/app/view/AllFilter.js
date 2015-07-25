Ext.define('ifeng.view.AllFilter', {
    extend: 'Ext.form.Panel',
    alias: 'widget.allFilter',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    height: 250,
    layout: 'fit',
    bodyPadding: 10,
    title: '全部',

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
                                {fieldLabel: '视频概况', id: 'a_gk'},
                                {fieldLabel: '视频错误详情', id: 'a_cwxq'},
                                {fieldLabel: '视频资源信息', id: 'a_zyxx'},
                                {fieldLabel: '视频区域信息', id: 'a_qyxx'},
                                {fieldLabel: '视频全球平均播放统计', id: 'a_qqtj'},
                                {fieldLabel: 'IP 地域、运营商统计', id: 'a_iptj'}
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
                                {xtype: 'combobox', id: 'a_gk_rng'},
                                {xtype: 'combobox', id: 'a_cwxq_rng'},
                                {xtype: 'combobox', id: 'a_zyxx_rng'},
                                {xtype: 'combobox', id: 'a_qyxx_rng'},
                                {xtype: 'combobox', id: 'a_qqtj_rng'},
                                {xtype: 'combobox', id: 'a_iptj_rng'}
                            ]
                        },
                        {
                            xtype: 'form',
                            margin: 5,
                            width: 90,
                            header: false,
                            defaults: {
                            	text: '查询报表'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    handler: function(){
                                    	var type = Ext.getCmp('a_gk').getValue()
                                    	var range = Ext.getCmp('a_gk_rng').getValue()
                                    	ifeng.app.getController('DailyController').doCheck(type, range);
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
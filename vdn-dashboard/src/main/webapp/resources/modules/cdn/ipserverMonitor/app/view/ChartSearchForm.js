/**
 * 
 */
// Add the additional 'advanced' VTypes
Ext.apply(Ext.form.field.VTypes, {
    daterange: function(val, field) {
        var date = field.parseDate(val);

        if (!date) {
            return false;
        }
        if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
            var start = field.up('form').down('#' + field.startDateField);
            start.setMaxValue(date);
            start.validate();
            this.dateRangeMax = date;
        }
        else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
            var end = field.up('form').down('#' + field.endDateField);
            end.setMinValue(date);
            end.validate();
            this.dateRangeMin = date;
        }
        /*
         * Always return true since we're only using this vtype to set the
         * min/max allowed values (these are tested for after the vtype test)
         */
        return true;
    },

    daterangeText: 'Start date must be less than end date',

    password: function(val, field) {
        if (field.initialPassField) {
            var pwd = field.up('form').down('#' + field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText: 'Passwords do not match'
});
    
Ext.define('ifeng.view.ChartSearchForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.chartSearchForm',
	requires: ['Ext.ux.DataTip', 'Ext.ux.DateTimeField'],

	title: '过滤数据',
	header: false,
	
	frame: true,
    collapsible: true,
    
    defaults: {
    	anchor: '100%'
    },
    
    tbar: [{
    	xtype: 'fieldset',
    	title: '',
        margin: '1 1 1 1',
        layout: 'column',
        width: '100%',
        collapsible: true,
        defaults: {
            labelAlign: 'right',
            anchor: '100%'
        },
    	items: [{
    		columnWidth: .5,
    		items:[{
    			xtype: 'datetimefield',
    			fieldLabel: '开始日期',
    			name: 'startdt',
    			itemId: 'startdt',
    			vtype: 'daterange',
    			format: 'Y-m-d H:i:s',
    			endDateField: 'enddt' // id of the end date field
    		}]
    	},{
    		columnWidth: .5,
    		items: [{
    			xtype: 'datetimefield',
    			fieldLabel: '结束日期',
    			name: 'enddt',
    			itemId: 'enddt',
    			vtype: 'daterange',
    			format: 'Y-m-d H:i:s',
    			startDateField: 'startdt' // id of the start date field
    		}]
    	},{
    		width: 75,
    		xtype: 'button',
    		action: 'doFilter',
    		iconCls: 'icon-filter',
    		text: '过滤'
    	}]
    }]/*,
   
    
    buttons: [{
        text: '查询',
        iconCls: 'icon-search',
        action: 'doSearch'
    },{
        text: '重置',
        iconCls: 'icon-cancel',
        action: 'doReset'
    }]*/
})
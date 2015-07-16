/**
 * 
 */
Ext.define('ifeng.model.AliIPModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
		'country',
		'country_id',
		'area',
		'area_id',
		'region',
		'region_id',
		'city',
		'city_id',
		'county',
		'county_id',
		'isp',
		'isp_id',
		'ip' 
	]
	
});
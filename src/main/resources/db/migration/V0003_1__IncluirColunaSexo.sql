BEGIN
	IF NOT EXISTS (SELECT * FROM sys.columns WHERE object_id = OBJECT_ID(N'TESTE_IAGO.PESSOA') AND name = 'SEXO')
		ALTER TABLE TESTE_IAGO.PESSOA ADD SEXO INT NULL
END